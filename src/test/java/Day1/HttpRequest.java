package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequest {
	// url :https://reqres.in/
int id;
	@Test(priority=1)
	void getUser() {
		given()
		.when()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		  .statusCode(200)
		  .body("page", equalTo(2))
		  .log().all();
	}
   @Test(priority=1)
   void createUser()
   {
	   HashMap hm=new HashMap();
	   hm.put("name", "sai");
	   hm.put("job", "QE");
	   id= given()
	     .contentType("application/json").body(hm)
	   .when()
	     .post("https://reqres.in/api/users")
	      .jsonPath().getInt("id");
//	   .then()
//	     .statusCode(201)
//	     .log().all();
//	   
   }


@Test(priority=3,dependsOnMethods= {"createUser"})
   void updateUser()
   {
	HashMap hm=new HashMap();
	   hm.put("name", "ramu");
	   hm.put("job", "df");
	   given()
	     .contentType("application/json").body(hm)
	   .when()
	     .put("https://reqres.in/api/users/"+id)
	     .then()
	     .statusCode(200)
         .log().all();

   }
@Test(priority=4,dependsOnMethods= {"createUser"})
void deleteUser()
{
	   given()   
	   .when()
	   .delete("https://reqres.in/api/users/"+id)
	     .then()
	     .statusCode(204)
      .log().all();

}
}