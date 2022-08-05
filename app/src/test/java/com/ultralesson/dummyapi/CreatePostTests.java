package com.ultralesson.dummyapi;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePostTests {

    @Test
    public void shouldCreatePost(){

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id","62ec2b3c9e703f23bf6fc8a3")
                .body("{\n" +
                        "    \"text\" : \"this is the second post\",\n" +
                        "    \"image\" : \"sample1url.com\",\n" +
                        "    \"likes\" : 2,\n" +
                        "    \"tags\" : [\"water\"],\n" +
                        "    \"owner\" : \"62ec877286168f6c090dfd6d\"\n" +
                        "}")
                .when()
                    .post("https://dummyapi.io/data/v1/post/create")
                .then()
                    .log().body()
                    .statusCode(200);
    }
}
