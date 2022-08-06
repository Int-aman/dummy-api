package com.ultralesson.dummyapi.smoketests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostTests {

    @Test
    public void getPostById(){
        given()
                    .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                .when()
                    .get("https://dummyapi.io/data/v1/post/62ec877f86168f28820dfd82")
                .then()
                    .statusCode(200)
                    .log().body();
    }
}
