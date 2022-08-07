package com.ultralesson.dummyapi.users.post;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;

import static io.restassured.RestAssured.given;

@Getter
public class PostClient {


    public Response create(PostRequest body){
        Response  response =
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                        .body(body)
                        .when()
                        .post("https://dummyapi.io/data/v1/post/create");

        response.then().log().body();
        return response;
    }

}
