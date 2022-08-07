package com.ultralesson.dummyapi.smoketests;

import com.ultralesson.dummyapi.users.UsersService;
import com.ultralesson.dummyapi.users.create.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.create.response.CreateErrorResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeCreateUserTests {

    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService = new UsersService();
    }
    @Test(groups = {"smoke"} )
    public void shouldNotAllowToCreateUserWithInvalidEmail(){

        //Arrange
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .firstName("Rama").lastName("Kumar")
                .email("ramlal@gmail.com").build();

        //Act
        CreateErrorResponse errorResponse = usersService.createUserExpectingResponse(requestBody);

        //Assert
        assertEquals(errorResponse.getStatusCode(), 400);
        errorResponse.assertHasError("Email already used");
    }
}
