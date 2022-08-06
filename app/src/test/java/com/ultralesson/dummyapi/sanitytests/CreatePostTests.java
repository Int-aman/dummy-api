package com.ultralesson.dummyapi.sanitytests;

import com.ultralesson.dummyapi.users.post.PostClient;
import com.ultralesson.dummyapi.users.post.PostRequest;
import com.ultralesson.dummyapi.users.post.PostResponse;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePostTests {

    private PostClient postClient;

    @BeforeClass
    public void beforeClass(){
        postClient = new PostClient();
    }

    @Test
    public void shouldCreatePost(){

        //Arrange
        PostRequest postBody = PostRequest.builder()
                .text("this is text")
                .image("sample-image-url.com")
                .owner("62ec877286168f6c090dfd6d")
                .likes(33)
                .build();

        //Act
        PostResponse postResponse = postClient.createPost(postBody);

        //Assert
        postResponse.assertPost(postBody);
    }
}
