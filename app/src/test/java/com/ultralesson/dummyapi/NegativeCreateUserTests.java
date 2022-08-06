package com.ultralesson.dummyapi;

import com.ultralesson.dummyapi.users.UsersClient;
import com.ultralesson.dummyapi.users.create.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.create.response.CreateErrorResponse;
import com.ultralesson.dummyapi.users.create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class NegativeCreateUserTests {

    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){

        //Arrange
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .firstName("Rama").lastName("Kumar")
                .email("ramlal@gmail.com").build();

        //Act
        CreateErrorResponse errorResponse = usersClient.createUserExpectingResponse(requestBody);

        //Assert
        assertEquals(errorResponse.getStatusCode(), 400);
        errorResponse.assertHasError("Email already used");
//        given()
//                .accept(ContentType.JSON)
//                .contentType(ContentType.JSON)
//                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
//                .body("{\n" +
//                        "    \"firstName\" : \"Ram\",\n" +
//                        "    \"lastName\" : \"Lal\",\n" +
//                        "    \"email\" : \"ramlal@gmail.com\"\n" +
//                        "}")
//                .when()
//                .post("https://dummyapi.io/data/v1/user/create")
//                .then()
//                .log().body()
//                .statusCode(400);
    }
}
