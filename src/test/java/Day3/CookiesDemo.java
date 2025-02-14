package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	//@Test
	void testcookies() {
		//in this mehtod we are checking cookies are present or not and validate that cookie name
		//for multiple cooki
		given()
		.when().get("https://www.google.com/")
		.then().cookie("AEC","AVcja2dypVozaTbtYcqx1hx5qvvt3zoiTq0S9QkCW8C9OvwSQgRyxEpv23s")
		.log().all();
	}
    @Test
	void gettestcookies() {
		//in this mehtod we are checking cookies are present or not and validate that cookie name
		//for multiple cooki
		Response res=given()
		.when().get("https://www.google.com/");
		
		//get single cookie info return types is string
		String cookie_value=res.getCookie("AEC");
		System.out.println(cookie_value);
		
		//get all the cookies info and return type is Map (key value pairs --need to understand map concept)
		Map<String,String> allCookies_values=res.getCookies();
		
		System.out.println(allCookies_values.keySet());//to print all the keys information
		//know the key and pass the key and get value using for each loop
		for(String k:allCookies_values.keySet())
		{
		   String cookie1_value	=res.getCookie(k);
		   System.out.println( k +" -----  >"+cookie1_value);
		}
		
		//same thing we can do for headers also for values of headers also same  n't like cookies values
		
		
	}
}
