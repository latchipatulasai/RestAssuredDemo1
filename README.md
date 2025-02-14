# RestAssuredDemo2

Prerequsites:

URLS:https://reqres.in/api 

required dependencies: rest-assured, testng, hamcrest, jackson-databind, jackson-core, json


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


