# RestAssuredDemo2



given(): prerequisetes

wehn():get ,pust post,delete

then():validate status code,extract response,extract headers cookies,

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

Update user:

https://reqres.in/api/users/2
{
    "name": "morpheus",
    "job": "zion resident"
}

Delete User:

https://reqres.in/api/users/2
