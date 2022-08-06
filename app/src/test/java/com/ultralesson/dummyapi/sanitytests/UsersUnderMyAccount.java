package com.ultralesson.dummyapi.sanitytests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersUnderMyAccount {

    @Test(groups = {"sanity"} )
    public void shouldGetAllUsersUnderMyAccount(){
        given()
                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                .when()
                    .get("https://dummyapi.io/data/v1/user?created=1")
                .then()
                    .statusCode(200)
                    .log().body();
    }
}
