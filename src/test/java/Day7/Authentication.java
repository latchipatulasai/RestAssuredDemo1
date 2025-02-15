package Day7;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authentication {
	@Test
	// basic authentication--just type username and password
	void testBasicAuthentication() {
		
		given().auth().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	
	@Test
	// basic authentication--just type username and password
	void testDigestAuthentication() {
		
		given().auth().digest("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	@Test
	// preemptive authentication--just type username and password (combianation of digit basic)
	void testPreemptiveAuthentication() {
		
		given().auth().preemptive().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}

}
