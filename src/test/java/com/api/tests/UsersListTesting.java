package com.api.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class UsersListTesting {
	@Test(priority = 2, dependsOnMethods = {"com.api.tests.LoginTest.testValidLoginAPI"})
	public void testUsersListWithToken() {
		 System.out.println("Token being sent: " + AuthToken.token); // ensuring the security
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + AuthToken.token)
		        .contentType("application/json")
		        .when()
		        .get("api/users")
		        .then()
		        .log().all()  // Logs response for debugging
		        .statusCode(200)
		        .extract().response();  // Extract the response
		        System.out.println("Users list successfully loaded using token: " + AuthToken.token);// for security
		}
	@Test(priority = 3)
	public void testUsersListWithOutToken() {
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + null)
		        .contentType("application/json")
		        .when()
		        .get("api/users")
		        .then()
		        .log().all()  // Logs response for debugging
		        .statusCode(403)
		        .extract().response();  // Extract the response
		        System.out.println("Users list not successfully loaded ! Invalid Credentials");
		}
	
	

}
