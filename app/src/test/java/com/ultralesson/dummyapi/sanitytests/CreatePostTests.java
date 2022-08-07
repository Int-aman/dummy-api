package com.ultralesson.dummyapi.sanitytests;

import com.ultralesson.dummyapi.users.post.PostRequest;
import com.ultralesson.dummyapi.users.post.PostResponse;
import com.ultralesson.dummyapi.users.post.PostService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatePostTests {

    private PostService postService;

    @BeforeClass
    public void beforeClass(){
        postService = new PostService();
    }

    @Test(groups = {"sanity"} )
    public void shouldCreatePost(){

        //Arrange
        PostRequest postBody = PostRequest.builder()
                .text("this is text")
                .image("sample-image-url.com")
                .owner("62ec877286168f6c090dfd6d")
                .likes(33)
                .build();

        //Act
        PostResponse postResponse = postService.createPost(postBody);

        //Assert
        postResponse.assertPost(postBody);
    }
}
