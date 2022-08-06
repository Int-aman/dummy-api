package com.ultralesson.dummyapi.users;

import com.ultralesson.dummyapi.users.create.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.create.response.CreateUserResponse;
import com.ultralesson.dummyapi.users.create.response.CreateErrorResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {


    public Response create(CreateUserRequestBody body){
        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                        .body(body)
                .when()
                        .post("https://dummyapi.io/data/v1/user/create");

        response.then().log().body();
        return response;
    }
}
