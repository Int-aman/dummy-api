package com.ultralesson.dummyapi.users.post;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostService {

    public PostResponse createPost(PostRequest body){
        Response response = new PostClient().create(body);
        PostResponse postResponse = response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
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
