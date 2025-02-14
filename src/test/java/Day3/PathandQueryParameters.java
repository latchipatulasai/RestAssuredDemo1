package Day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PathandQueryParameters {
	
	
	@Test
	void testQueryAndPathParameters()
	{
		
//		.pathParam("mypath", "users")// specifying  path parameters'
//		.queryParam("page", 2)//specifying query  parameters--pls find below
		
		given()
		.pathParam("mypath", "users")// specifying  path parameters'
		.queryParam("page", 2)//specifying query  parameters
		.queryParam("id", 5)
		.when().get("https://reqres.in/api/{mypath}")
		.then().statusCode(200)
		  .log().all();
	}

}
