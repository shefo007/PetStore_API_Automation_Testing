package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static api.endpoints.Routes.*;
import static io.restassured.RestAssured.*;

public class User_EndPoints {

    static Response response;

    public static Response createUser(User payload){

        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
        .when()
                .post(userPost_url);

        return response;
    }


    public static Response readUser(String username) {

        response = given()
                .accept(ContentType.JSON)
                .pathParam("username", username)
        .when()
                .get(userGet_url);

        return response;
    }

    public static Response updateUser(String username, User payload) {

        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
        .when()
                .put(userUpdate_url);

        return response;
    }

    public static Response deleteUser(String username) {

        response = given()
                .accept(ContentType.JSON)
                .pathParam("username", username)
        .when()
                .delete(userDelete_url);

        return response;
    }
}
