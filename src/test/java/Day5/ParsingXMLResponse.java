package Day5;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class ParsingXMLResponse {
	@Test
	void testXMLResponse() {
		
		given()
		.when().get("https://fakerestapi.azurewebsites.net/api/v1/CoverPhotos?id=1")
		.then().statusCode(200)
		.header("Content-Type","application/json; charset=utf-8; v=1.0")
		.log().all();
		//in Xml parsing we use child node like table we write an xpath
		//approach2
		//approach2
		
		//res.xmlPath().get("Tr").toString(); //same as Parsing JSONResponseData
		

	}

}
