package com.ultralesson.dummyapi.sanitytests;

import com.ultralesson.dummyapi.users.UsersClient;
import com.ultralesson.dummyapi.users.create.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateUser(){

        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                        .firstName("Rama").lastName("Kumar")
                        .email(email).build();

        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);

        //Assert
        createUserResponse.assertUser(requestBody);
    }
}
