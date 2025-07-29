package com.api.tests;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class UserUpdationTest {
	@Test(priority = 6, dependsOnMethods = {"com.api.tests.UserCreationTest.testCreateUserWithToken"})
    public void testUpdateUserWithToken() {
		 System.out.println("Token being sent: " + AuthToken.token); // ensuring the security
		 System.out.println("User id being sent: " + UserID.userId); // ensuring the correct user id
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + AuthToken.token)
		        .contentType("application/json")
		        .body("{\r\n"
		            + "  \"firstName\": \"Arya Stark\",\r\n"
		            + "  \"lastName\": \"NJames Cut\",\r\n"
		            + "  \"email\": \"james@examplecareer.com\"\r\n"
		            + "}")
		    .when()
		        .put("api/users/"+UserID.userId)
		    .then()
		        .log().all()  // Logs response for debugging
		        .statusCode(200)
		        .body("firstName", equalTo("Arya Stark"))
		        .body("lastName", equalTo("NJames Cut"))
		        .body("email", equalTo("james@examplecareer.com"))
		        .extract().response();  // Extract the response
		    System.out.println(" Updated User ID: " + UserID.userId);
		    System.out.println("User updated successfully using token: " + AuthToken.token);// for security
		}
	@Test(priority=7)
	public void testUpdateUserWithOutIdPassed() {
		 System.out.println("Token being sent: " + AuthToken.token); // ensuring the security
		 System.out.println("User id being sent: " + UserID.userId); // ensuring the correct user id
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + AuthToken.token)
		        .contentType("application/json")
		        .body("{\r\n"
		            + "  \"firstName\": \"Arya Stark\",\r\n"
		            + "  \"lastName\": \"NJames Cut\",\r\n"
		            + "  \"email\": \"james@examplecareer.com\"\r\n"
		            + "}")
		    .when()
		        .put("api/users/"+1953556904)
		    .then()
		        .log().all()  // Logs response for debugging
		        .statusCode(404)
		        .extract().response();  // Extract the response
		      System.out.println("User Not Found (404)"+response.statusCode());
		}
}
