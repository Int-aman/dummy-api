package com.ultralesson.dummyapi.users.create.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CreateErrorResponse {

    @Setter
    private int statusCode;
    private String error;
    private Data data;

    public void assertHasError(String message){
        Assert.assertEquals(data.getEmail(),message);

    }

    @Getter
    public static class Data {
        private String email;
        private String lastName;
        private String firstName;

    }

}
