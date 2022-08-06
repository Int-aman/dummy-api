package com.ultralesson.dummyapi.smoketests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUserTests {

    @Test(groups = {"smoke"} )
    public void shouldGetAllUsers(){
        given()
                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                .when()
                    .get("https://dummyapi.io/data/v1/user")
                .then()
                    .statusCode(200)
                    .log().body();
    }
}
