package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//poj0 ----- Serilize --->JSON Object --deseilize --->POJO
//pojo -->json
public class SerilizationDeserilization {

	//@Test
	void ConvertPojo2Json() throws Exception {
		//pojo -->json Serilize
		Student data = new Student();

		data.setName("kiran");
		data.setLocation("Italy");
		data.setPhone("986878787");
		String courseArr[] = { "c", "v++" };
		data.setCourses(courseArr);

		// conver java object --> json object(serialization)
		ObjectMapper objmapper = new ObjectMapper();
		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
	}

	//desrializaton json -->pojo
	@Test
	void ConvertJson2pojo() throws Exception {
		//json -->pojo desrializaton
		String jsondata="{\r\n"
				+ "  \"name\" : \"kiran\",\r\n"
				+ "  \"location\" : \"Italy\",\r\n"
				+ "  \"phone\" : \"986878787\",\r\n"
				+ "  \"courses\" : [ \"c\", \"v++\" ]\r\n"
				+ "}";
		
		
		//convert json data  --> pojo object
		ObjectMapper objmapper=new ObjectMapper();
		Student stupojo=objmapper.readValue(jsondata, Student.class);
		System.out.println(stupojo.getName());
		System.out.println(stupojo.getLocation());
		System.out.println(stupojo.getCourses());
	}

}
