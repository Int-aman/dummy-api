package com.ultralesson.dummyapi.users.post;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Getter
public class PostClient {

    public PostResponse createPost(PostRequest body){
        Response response = create(body);
        PostResponse postResponse = response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
    }
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

    public PostResponse getPostById(String id){
        Response response = given()
                    .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                    .pathParam("id",id)
                .when()
                    .get("https://dummyapi.io/data/v1/post/{id}");

        response.then().log().body();

        int statusCode = response.statusCode();

        PostResponse postResponse = response.as(PostResponse.class);
        postResponse.setStatusCode(statusCode);
        return postResponse;

    }

    public void confirmPostDeleted(String id){
        //String id = "23fdg2dg2wer3";
        given()
                    .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                    .pathParam("id",id)
                .when()
                    .get("https://dummyapi.io/data/v1/post/{id}")
                .then()
                    .statusCode(404)
                    .log().body();
    }
}
