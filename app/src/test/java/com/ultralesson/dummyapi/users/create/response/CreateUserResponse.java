package com.ultralesson.dummyapi.users.create.response;

import com.ultralesson.dummyapi.users.create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;
    //private Data data;
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private String registerDate;
    private String updatedDate;

    public void assertUser(CreateUserRequestBody requestBody){
        assertEquals(this.getStatusCode(), 200);
        assertNotNull(this.getId());
        assertEquals(this.getFirstName(), requestBody.getFirstName());
        assertEquals(this.getLastName(), requestBody.getLastName());
        assertEquals(this.getEmail(), requestBody.getEmail());
    }
}
