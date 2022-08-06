package com.ultralesson.dummyapi.smoketests;

import com.ultralesson.dummyapi.users.UsersClient;
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
