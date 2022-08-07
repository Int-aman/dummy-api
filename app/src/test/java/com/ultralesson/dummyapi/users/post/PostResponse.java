package com.ultralesson.dummyapi.users.post;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
public class PostResponse {

    @Setter
    private int statusCode;

    private String id;
    private String image;
    private int likes;
    private String link;
    List<String> tags;
    private String text;
    private String publishDate;
    private String updatedDate;
    private Owner owner;

    public void assertPost(PostRequest requestPost){
        Assert.assertEquals(this.getStatusCode(),200);
        Assert.assertNotNull(this.getId());
        Assert.assertEquals(this.getText(),requestPost.getText());
        Assert.assertEquals(this.getLikes(),requestPost.getLikes());
    }
    @Getter
    public class Owner{
        private String id;
        private String lastName;
        private String firstName;
    }
}
