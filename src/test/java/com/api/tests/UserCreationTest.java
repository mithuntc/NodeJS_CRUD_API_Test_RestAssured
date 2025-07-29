package com.api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class UserCreationTest {
	@Test(priority = 4, dependsOnMethods = {"com.api.tests.LoginTest.testValidLoginAPI"})
    public void testCreateUserWithToken() {
		 System.out.println("Token being sent: " + AuthToken.token); // ensuring the security
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + AuthToken.token)
		        .contentType("application/json")
		        .body("{\r\n"
		            + "  \"firstName\": \"Micheal clark\",\r\n"
		            + "  \"lastName\": \"Navy jhon\",\r\n"
		            + "  \"email\": \"johnSmith@examplecareer.com\"\r\n"
		            + "}")
		    .when()
		        .post("api/users")
		    .then()
		        .log().all() // This steps is to log when debugging is necessary
		        .statusCode(201)
		        .body("firstName", equalTo("Micheal clark"))
		        .body("lastName", equalTo("Navy jhon"))
		        .body("email", equalTo("johnSmith@examplecareer.com"))
		        .extract().response();  // Extract the response
		    UserID.userId = response.jsonPath().getString("id"); // copying the id of the user from actual response
		    System.out.println("User ID: " + UserID.userId);
		    System.out.println("User created successfully using token: " + AuthToken.token);// for security
		}
	
	@Test(priority = 5)
	public void testCreateUserWithOutToken() {
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + null)
		        .contentType("application/json")
		        .body("{\r\n"
		            + "  \"firstName\": \"Micheal clark\",\r\n"
		            + "  \"lastName\": \"Navy jhon\",\r\n"
		            + "  \"email\": \"johnSmith@examplecareer.com\"\r\n"
		            + "}")
		    .when()
		        .post("api/users")
		    .then()
		        .log().all() // This steps is to log when debugging is necessary
		        .statusCode(403)
		        .extract().response();  // Extract the response
		    System.out.println("User not  created successfully ! Unauthorized");
		}
}
