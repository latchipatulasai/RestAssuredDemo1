package Day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingDemo {

	@Test
	void testlog() {
		//in this mehtod we are priting how many ways to print logingh
		
		 
		given()
		.when().get("https://www.google.com/")
		.then().log().body()//it will print only body from the response means code
		.log().cookies()//It will print only cookis
		.log().headers()//it will pring only headesrs
		.log().all();//it will print all 
	}

}
