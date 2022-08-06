package com.ultralesson.dummyapi.users.post;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostRequest {

    private String text;
    private String image;
    private String owner;
    private int likes;
}
