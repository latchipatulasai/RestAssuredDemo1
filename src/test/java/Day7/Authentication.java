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
	//@Test
	// basic authentication--just type username and password
	void testBasicAuthentication() {
		
		given().auth().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	
	//@Test
	// basic authentication--just type username and password
	void testDigestAuthentication() {
		
		given().auth().digest("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	//@Test
	// preemptive authentication--just type username and password (combianation of digit basic)
	void testPreemptiveAuthentication() {
		
		given().auth().preemptive().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}

//@Test
// bearer Token
void testBearerTokenAuthentication() {
	//taking barer token
	String bearerToken="ghp_24pH0Icz1PKHC1qOtLwj57AuDYmtSz2fuYKP";
	given().headers("Authorization","Bearer "+bearerToken)
	.when().get("https://api.github.com/user/repos")
	.then()
	.statusCode(200)
	.log().all();
	
}
@Test
//OAuth2 is same as OAuth1   Token but no of required parametrs is decreased -developer will give these details like consumerkey,consumersecrat, access token,tokensecrate
void testOauth2Authentication() {
	//taking barer token
	given().auth().oauth2("ghp_24pH0Icz1PKHC1qOtLwj57AuDYmtSz2fuYKP")
	.when().get("https://api.github.com/user/repos")
	.then()
	.statusCode(200)
	.log().all();
	
}
//@Test
//oAuth1  Token -developer will give these details like consumerkey,consumersecrat, access token,tokensecrate
void testOauth1Authentication() {
	//
	given().auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
	.when().get("url")
	.then()
	.statusCode(200)
	.log().all();
	
}

@Test
//quey params we nedd to give api key authentication
void testAPIKeyAuthentication() {
	// used to pass quey params
	given()
	.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
	.when().get("api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
     .then().statusCode(200)
     .log().all();
	
	
}
}