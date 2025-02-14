package Day5;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class FileUpload {
    @Test
	void singleFileUpload() {
    	//nee to give file path in given precondintion gave in given
    	//to specify form u have one method and file is parameter for single file upload
 	   File myfile =new File("path");
    	given().multiPart("file","myfile")
    	.contentType("multipart/form-data")

    	.when()
    	.post("url like https://")
    	.then().statusCode(200);
    //like that u can some more validations
    	

	}
    @Test
	void multipleFileUpload() {
    	//nee to give file path in given precondintion gave in given
    	//to specify form u have one method,files is parameter for multiple file upload
 	   File myfile1 =new File("path");
 	  File myfile2 =new File("path");
    	given().multiPart("files",myfile1)
    	.multiPart("files",myfile2)
    	.contentType("multipart/form-data")

    	.when()
    	.post("url like https://")
    	.then().statusCode(200);
    //like that u can some more validations
    	

	}
    
    
    @Test
   	void FileDownload() {
       	//nee to give file path in given precondintion gave in given
       	//if file downlaod a new request will avialbe if you that request using get and status code 200 the file down;loaded
        given()
       	.when()
       	.post("url like https://")
       	.then().statusCode(200);
       //like that u can some more validations
       	

   	}
    @Test
   	void Fileupload() {
       	//nee to give file path in given precondintion gave in given
       	//if file upload a new request will avialbe if you that request using get and status code 200 the file uploaded
        given()
       	.when()
       	.post("url like https://")
       	.then().statusCode(200);
       //like that u can some more validations
       	

   	}
}
