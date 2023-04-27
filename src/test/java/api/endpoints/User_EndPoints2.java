package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

// Using routes from properties file
public class User_EndPoints2 {

    static Response response;

    // method created to get URLs from properties file
    static ResourceBundle getURL() {
        return ResourceBundle.getBundle("routes");
    }

    public static Response createUser(User payload){

        String postUrl = getURL().getString("post_url");
        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
        .when()
                .post(postUrl);

        return response;
    }


    public static Response readUser(String username) {

        String getUrl = getURL().getString("get_url");
        response = given()
                .accept(ContentType.JSON)
                .pathParam("username", username)
        .when()
                .get(getUrl);

        return response;
    }

    public static Response updateUser(String username, User payload) {

        String updateUrl = getURL().getString("update_url");
        response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
        .when()
                .put(updateUrl);

        return response;
    }

    public static Response deleteUser(String username) {

        String deleteUrl = getURL().getString("delete_url");
        response = given()
                .accept(ContentType.JSON)
                .pathParam("username", username)
        .when()
                .delete(deleteUrl);

        return response;
    }
}
