package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;

public class LoginTest {

    @BeforeClass
    public void setupLogin() {
        testValidLoginAPI(); // Ensures token is available before other tests run
    }

    @Test(priority = 1)
    public void testValidLoginAPI() {
        Response response = RestAssured
                .given()
                    .baseUri("http://localhost:3000")
                    .header("Content-Type", "application/json")
                    .body("{ \"username\": \"admin\", \"password\": \"admin123\" }")
                .when()
                    .post("/api/login")
                .then()
                    .log().all()
                    .extract().response();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        assertEquals(response.getStatusCode(), 200); //asserting the status code
        AuthToken.token = response.jsonPath().getString("token");
        System.out.println("TOKEN SAVED: " + AuthToken.token);
    }

    @Test(priority = 2)
    public void testInValidLoginAPI() {
        Response response = RestAssured
                .given()
                    .baseUri("http://localhost:3000")
                    .header("Content-Type", "application/json")
                    .body("{ \"username\": \"admin\", \"password\": \"admin12355\" }")
                .when()
                    .post("api/login")
                .then()
                    .log().all()
                    .extract().response();

        System.out.println("Status Code: " + response.getStatusCode());
        assertEquals(response.getStatusCode(), 401);//asserting the status code
    }
}