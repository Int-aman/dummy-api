package com.ultralesson.dummyapi.smoketests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostTest {

    //@Test
    public void shouldDeletePost(){
        given()
                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                .when()
                    .delete("https://dummyapi.io/data/v1/post/62ecc16b98146a0dff3dfdfa")
                .then()
                    .statusCode(200)
                    .log().body();
    }
}
