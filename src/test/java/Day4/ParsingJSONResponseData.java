package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData {
	@Test(priority=1)
	void testJsonResponse() {
		given()
		.when().get("https://localhost:/store")
		.then().statusCode(200)
		.header("Content-Type", "aplication/json; charset=utf-8")
		//go to jsonpathfinder website for getting josn path for particular element
		.body("book[3].title", equalTo("sword og honor"));
	
		
		  //approch 2 
		  Response res=given().contentType(ContentType.JSON)
		.when().get("https://localhost:/store");
		  //two types assertions and hrmmatch assertions before all are hrm matchers ,below we used testng assertions
		  Assert.assertEquals(res.getStatusCode(),200);
		  Assert.assertEquals(res.header("Content-Type"),"aplication/json; charset=utf-8");//like this way you can validate all
		String bookname= res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname, "sword og honor");
		//apart from this we can do more validation compare to hrm matchers and testng
		

	}
	
	@Test(priority=2)
	void testJsonResponseBodyData() {
		
	
		
		  
		  Response res=given().contentType(ContentType.JSON)
		.when().get("https://localhost:/store");
		  //two types assertions and hrmmatch assertions before all are hrm matchers ,below we used testng assertions
//		  Assert.assertEquals(res.getStatusCode(),200);
//		  Assert.assertEquals(res.header("Content-Type"),"aplication/json; charset=utf-8");//like this way you can validate all
//		String bookname= res.jsonPath().get("book[3].title").toString();
//		Assert.assertEquals(bookname, "sword og honor");
//		//apart from this we can do more validation compare to hrm matchers and testng
//   
//	   JSONObject class   ->dep->json
		  
		  JSONObject jo=new JSONObject(res.toString());  //converting response to JSON Object type
		  for(int i=0;i<jo.getJSONArray("book").length();i++)
		  {
			  String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		  }

	}

}
