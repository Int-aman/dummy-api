package com.ultralesson.dummyapi.sanitytests;

import com.ultralesson.dummyapi.users.UsersService;
import com.ultralesson.dummyapi.users.create.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateUserTests {

    private UsersService usersService;

    @BeforeClass
    public void beforeClass(){
        usersService = new UsersService();
    }

    @Test(groups = {"sanity"} )
    public void shouldCreateUser(){

        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                        .firstName("Rama").lastName("Kumar")
                        .email(email).build();

        //Act
        CreateUserResponse createUserResponse = usersService.createUser(requestBody);

        //Assert
        createUserResponse.assertUser(requestBody);
    }
}
