package com.ultralesson.dummyapi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NegativeCreateUserTests {

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                .body("{\n" +
                        "    \"firstName\" : \"Ram\",\n" +
                        "    \"lastName\" : \"Lal\",\n" +
                        "    \"email\" : \"ramlal@gmail.com\"\n" +
                        "}")
                .when()
                .post("https://dummyapi.io/data/v1/user/create")
                .then()
                .log().body()
                .statusCode(400);
    }
}
