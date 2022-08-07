package com.ultralesson.dummyapi.users.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

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
