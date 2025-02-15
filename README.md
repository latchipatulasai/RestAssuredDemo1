_# RestAssuredDemo2

Prerequsites:

URLS:https://reqres.in/api 

required dependencies: rest-assured, testng, hamcrest, jackson-databind, jackson-core, json,json-path,json-schema-validator


# Session:1 

API:An API is interface or intermediate between and user and application, For Example Take Restaaurent Customer,Waiter,Kitchen

Waiter takes order from the customer and Takes food from the kitchen and serves to Customer,Here Waiter is an API(Application Programming Interface)

RestAssured:IT an Liabrary which used to automate RestAPI only using testng--testng is mandatory

in restassured we use three keywords -given(),when(),then(),and()-here and is not used mostly

given(): prerequisetes (giving file paths like that)

when():get ,pust post,delete(Giving request ,what type request you want that thing  nee to provide)

then():validate status code,extract response,extract headers cookies, 

Here and() is not used mostly ,some time we used in then() key word  only for validation

Need to add three packages by defaults

import io.restassured.RestAssured;

import io.restassured.matcher.RestAssuredMatchers;

import org.hamcrest.Matchers.*;

-------
https://reqres.in/api
Given Users:

https://reqres.in/api/users?page=2

Post Users:

https://reqres.in/api/users
{
    "name": "morpheus",
    "job": "leader"
}

Update user:(put)

https://reqres.in/api/users/2
{
    "name": "morpheus",
    "job": "zion resident"
}

Delete User:

https://reqres.in/api/users/2

------------
# Session2:

# Different ways to create POST request body

1)post request body using Hashmap :By creating Hashmap and send to that into given 

2)post request body creation using Org.JSON 

3)post request body creation using POJO  class

4)post request using external json file data

-----
# Session3:

# Path Parameters ,Query Parameters ,Headers,Cookies and Logging

https://reres.in/api/users?page=2-->

For the above example

api/users-path

https://reres.in->Domain

before question mark->that is path parameters ->https://reres.in/api/users

after questiong mark -->that is called Query parameter->page=2

# cookies and Headers :
Some times when you send data  cookies have created and what are the headers are created by the request and  i want to capture some data from cookies and Headers
Cookies : ![image](https://github.com/user-attachments/assets/b5ce8baa-366b-40c6-b927-41aae976932e)
Headers:  ![image](https://github.com/user-attachments/assets/e853faee-f4f3-48ba-99b5-18a1c5fcd52f)

# Logging

here to show how may ways to write a log 

log().body()//it will print only body from the response means code

.log().cookies()//It will print only cookis

.log().headers()//it will pring only headesrs

.log().all();//it will print all the data 

--------------
# Session:4

# Parsing Response Body || JSONObject

how to validate response data along wiht xml and Json  format-->for that we have a special classes available 

//go to jsonpathfinder website for getting josn path for particular element

.header("Content-Type", "aplication/json; charset=utf-8")

		//go to jsonpathfinder website for getting josn path for particular element
  
		.body("book[3].title", equalTo("sword og honor"));

  --this is one way to validate specific field in json
  
  //two types assertions and hrmmatch assertions before all are hrm matchers ,below we used testng assertions
  
		  Assert.assertEquals(res.getStatusCode(),200);
    
		  Assert.assertEquals(res.header("Content-Type"),"aplication/json; charset=utf-8");//like this way you can validate all
    
		String bookname= res.jsonPath().get("book[3].title").toString();
  
		Assert.assertEquals(bookname, "sword og honor");
  
		//apart from this we can do more validation compare to hrm matchers and testng
------------------------------------

  # Session 5

  # Parsing XML Response || File Upload and Download

  one api: http://restapi.adequateshop.com/api/Traveler?page=1
  
  http://restapi.adequateshop.com/api/Tourist?page=2
  
  https://fakerestapi.azurewebsites.net/index.html
  xmlpath


-->For uploading file need to run 
cmd >need to start api run the backend server like spring application

//nee to give file path in given precondintion gave in given
    	//to specify form u have one method and file is parameter for single file upload

     //nee to give file path in given precondintion gave in given
    	//to specify form u have one method,files is parameter for multiple file upload

  	//nee to give file path in given precondintion gave in given
       	//if file downlaod a new request will avialbe if you that request using get and status code 200 the file down;loaded

        	//nee to give file path in given precondintion gave in given
       	//if file upload a new request will avialbe if you that request using get and status code 200 the file uploaded
	----------------
# Session 6
# JSON/XML Schema Validations
-->In the respone what we are giving data is we  are giving correctly or not 
what ever response we capture the response is generated according to the schema or not so that we are going to according to schema or not
Response Validation -->validate the response (whtat kind of data)
Schema Validation-->validate the type(type of data)

JSon Response(.json) --> Json schema(.json)
XML Response(.xml)  --> xml schema(.xsd)

JSON:

In Postman we did same thing
run our stor api:http://localhost:3000/book
Take response and copy it and got Json Schema tool and paste then it will generate schema copy that ,come postman and paste it and compare
Same thing we can do in through automation

-josn-->jsonschema converter
url:https://jsonformatter.org//json-to-jsonschema

.when()
		.get("http://localhost:3000/store")
		.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
  
XML :still we can validate

postman doesn't support xml schema validation
For  xml schema generator : convertsimple.com
just like a json create seperate file

# Serializaton and De Serialization


Body (json format)--->request -->Response(json)
Serialization is the process of converting the state of an object into a byte stream, which can then be saved to a file or transferred over a network. Deserialization is the reverse process, where the byte stream is used to recreate the actual Java object in memory.

To make a Java object serializable, the class must implement the java.io.Serializable interface, which is a marker interface with no methods. The ObjectOutputStream class provides the writeObject() method for serialization, while the ObjectInputStream class provides the readObject() method for deserialization.


![image](https://github.com/user-attachments/assets/2514df75-6c4f-4f42-a77a-1f9905f15f18)


-------
# Session 7
# Types of Authorization || Faker Liabrary

Difference authentication an authorization

authentication :check user is valid or not

authorization :checks access what kinds of authentication for the user

# authentication types:

1)Basic

2)Digest

3)Preempive

4)Bearer token

5)oauth 1.0,2.0

6)API Key 

1)Basic

// basic authentication--just type username and password

	void testBasicAuthentication() {
		
		given().auth().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
2)Digest

// basic authentication--just type username and password

	void testDigestAuthentication() {
		
		given().auth().digest("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)

3)preemptive
// preemptive authentication--just type username and password (combianation of digit basic)

	void testPreemptiveAuthentication() {
		
		given().auth().preemptive().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)

  both three is same

  
4)bearer Token

//bearer Token 
//OAuth2 is same as OAuth1   Token but no of required parametrs is decreased -developer will give these details like consumerkey,consumersecrat, access token,tokensecrate

void testOauth2Authentication() {

	//taking barer token
 
	given().auth().oauth2("ghp_24pH0Icz1PKHC1qOtLwj57AuDYmtSz2fuYKP")
	.when().get("https://api.github.com/user/repos")
	.then()


5)oauth 1.0 and 2.0 ,2.0 is advanced than 1.0

//oAuth1 bearer Token -developer will give these details like consumerkey,consumersecrat, access token,tokensecrate

void testOauth1Authentication() {

	//taking barer token
 
	given().auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
	.when().get("url")

 //OAuth2 is same as OAuth1   Token but no of required parametrs is decreased -developer will give these details like consumerkey,consumersecrat, access token,tokensecrate
 
void testOauth2Authentication() {

	//taking barer token
 
	given().auth().oauth2("ghp_24pH0Icz1PKHC1qOtLwj57AuDYmtSz2fuYKP")
	.when().get("https://api.github.com/user/repos")

6)APIKey 

//quey params we nedd to give api key authentication

void testAPIKeyAuthentication() {

	// used to pass quey params
 
	given()
	.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
	.when().get("api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
 
 He Explaind about JSON ARRY and JSON OBJECT


 -------
 # Session 8 
 # API CHAINING

Chaining is nothing but response from one request is used to request for another request 

Examples:Transparency apis is an examples in ASH

 
