package Day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {

	//@Test
	void testheader() {
		//in this mehtod we are checking headers are present or not and validate that headers with type 
		 
		given()
		.when().get("https://www.google.com/")
		.then().header("Content-type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.and()
		.header("server","gws")
		.log().all();
	}
    @Test
	void gettestheader() {
		//in this mehtod we are checking headers are present or not and validate that header 
		//for multiple cooki
		Response res=given()
		.when().get("https://www.google.com/");
		
		//get single header info return types is String
		String header_value=res.getHeader("Content-Type");
		System.out.println(header_value);
		
		//get all the cookies info and return type is Headers Map (key value pairs --need to understand map concept)
		Headers header=res.getHeaders();
		
		
	
		//know the key and pass the key and get value using for each loop
		for(Header H:header)
		{
		   
		   System.out.println( H.getName() +" -----  >"+H.getValue());
		}
		
		//same thing we can do for headers also for values of headers also same  n't like cookies values
    }
}
