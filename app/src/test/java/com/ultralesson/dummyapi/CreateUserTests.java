package com.ultralesson.dummyapi;

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


//        given()
//                .accept(ContentType.JSON)
//                .contentType(ContentType.JSON)
//                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
//                .body("{\n" +
//                        "    \"firstName\" : \"Ram\",\n" +
//                        "    \"lastName\" : \"Lal\",\n" +
//                        "    \"email\" : \"ranqzsdwal@gmail.com\"\n" +
//                        "}")
//                .when()
//                    .post("https://dummyapi.io/data/v1/user/create")
//                .then()
//                    .log().body()
//                    .statusCode(200);
    }
}
