package com.ultralesson.dummyapi.users;

import com.ultralesson.dummyapi.users.create.CreateUserRequestBody;
import com.ultralesson.dummyapi.users.create.response.CreateErrorResponse;
import com.ultralesson.dummyapi.users.create.response.CreateUserResponse;
import io.restassured.response.Response;

public class UsersService {

    public CreateUserResponse createUser(CreateUserRequestBody body){
        Response response = new UsersClient().create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }
    public CreateErrorResponse createUserExpectingResponse(CreateUserRequestBody body){
        Response response = new UsersClient().create(body);
        CreateErrorResponse errorResponse = response.as(CreateErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;

        // test comment
    }
}
