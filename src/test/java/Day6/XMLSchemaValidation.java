package Day6;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class XMLSchemaValidation {
		
		@Test
		void xmlSchemaValidation()
		{
			//xm sxhema -->xml to xsd  file type is .xsd
			
			given()
			.when().get("http://localhost:3000/store")
			.then().assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("storeXmlSchema.json"));
			
		}

}
