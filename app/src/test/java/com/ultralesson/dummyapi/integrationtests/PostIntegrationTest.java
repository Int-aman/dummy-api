package com.ultralesson.dummyapi.integrationtests;

import com.ultralesson.dummyapi.users.post.PostClient;
import com.ultralesson.dummyapi.users.post.PostRequest;
import com.ultralesson.dummyapi.users.post.PostResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostIntegrationTest {

    private PostClient postClient;

    @BeforeClass
    public void beforeClass(){
        postClient = new PostClient();
    }

    @Test
    public void shouldCreateAndDeletePost(){

        //Arrange
        PostRequest postBody = PostRequest.builder()
                .text("this is text")
                .image("sample-image-url.com")
                .owner("62ec877286168f6c090dfd6d")
                .likes(33)
                .build();

        //Act
        PostResponse postResponse = postClient.createPost(postBody);
        postResponse.assertPost(postBody);
        String id = postResponse.getId();

        //Now we delete the post
        given()
                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                    .pathParam("id",id)
                .when()
                    .delete("https://dummyapi.io/data/v1/post/{id}")
                .then()
                    .statusCode(200)
                    .log().body();

        //Asserting that we deleted the post
        postClient.confirmPostDeleted(id);

    }
}
