package Day2;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
Different ways to create POST request body
1)post request body using Hashmap
2)post request body creation using Org.JSON
3)post request body creation using POJO  class
4)post request using external json file data
*/
public class DiffWaysToCreatePostRequestBody {

	String id;

	// 1)Post request body using HashMap
	//@Test(priority = 1)
	void testPostUsingHashMap() {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("name", "kiran");
		data.put("location", "Italy");
		data.put("phone", "986878787");
		String courseArr[] = { "c", "v++" };
		data.put("courses", courseArr);

		id = given().contentType("application/json").body(data)
				
			.when().post("http://localhost:3000/students").jsonPath()
				.getString("id");
//		.then()
//		  .statusCode(201)
//		  .body("name",equalTo("kiran"))
//		  .body("locaton",equalTo("Italy"))
//		  .body("phone",equalTo("986878787"))
//		.log().all();
	}

	// deleting studnet record
	//@Test(priority = 2)
	void testDelte() {
		given()
		.when().delete("http://localhost:3000/students/" + id)
		.then().statusCode(200).log().all();
	}

	// 2)post request body creation using Org.JSON
	//@Test(priority = 0)
	void testPostusingJsonLibrary() {
		// using json object we did
		JSONObject data = new JSONObject();
		data.put("name", "kiran");
		data.put("location", "Italy");
		data.put("phone", "986878787");
		String courseArr[] = { "c", "v++" };
		data.put("courses", courseArr);

		given().contentType("application/json").body(data.toString())
		
		.when().post("http://localhost:3000/students")

		.then().statusCode(201)
		.body("name", equalTo("kiran"))
		.body("location", equalTo("Italy"))
		.body("phone", equalTo("986878787"))
		.log().all();
	}
	//3)3)post request body creation using POJO  class --plain object java  -->here we are using getters and setters
	//@Test(priority = 1)
	void testPostusingPOJO() {
		// using json object we did
	Pojo_PostRequest data=new Pojo_PostRequest();
			data.setName( "kiran");
		data.setLocation( "Italy");
		data.setPhone( "986878787");
		String courseArr[] = { "c", "v++" };
		data.setCourses( courseArr);

		given().contentType("application/json").body(data)
		
		.when().post("http://localhost:3000/students")

		.then().statusCode(201)
		.body("name", equalTo("kiran"))
		.body("location", equalTo("Italy"))
		.body("phone", equalTo("986878787"))
		.log().all();
	}
	//4)post request using external json file data --create BODY.JSON in our project 
}
