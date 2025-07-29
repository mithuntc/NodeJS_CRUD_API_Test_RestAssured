package com.api.tests;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class UserDeletionTest {
	@Test(priority = 8, dependsOnMethods = {"com.api.tests.UserUpdationTest.testUpdateUserWithToken"})
	public void testDeleteUserWithToken() {
		 System.out.println("Token being sent: " + AuthToken.token); // ensuring the security
		 System.out.println("User id being sent: " + UserID.userId); // ensuring the correct user id
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + AuthToken.token)
		        .contentType("application/json")
		        .when()
		        .delete("api/users/"+UserID.userId)
		        .then()
		        .log().all()  // Logs response for debugging
		        .statusCode(200)
		        .extract().response();  // Extract the response
		    System.out.println("User Deleted successfully using token: " + AuthToken.token);// for security
		    //clearing UserId from Record
		    UserID.userId = null;
		}
	@Test(priority = 9)
	public void testDeleteUserWithWrongId() {
		 System.out.println("Token being sent: " + AuthToken.token); // ensuring the security
		    Response response = given()
		        .log().all()  // Logs request for debugging
		        .baseUri("http://localhost:3000")
		        .header("Authorization", "Bearer " + AuthToken.token)
		        .contentType("application/json")
		        .when()
		        .delete("api/users/"+ 1053556904)
		        .then()
		        .log().all()  // Logs response for debugging
		        .statusCode(403)
		        .extract().response();  // Extract the response
		    System.out.println("User Not Found !Forbidden");
		}
}
