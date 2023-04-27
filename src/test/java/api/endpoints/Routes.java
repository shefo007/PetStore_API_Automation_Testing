package api.endpoints;


import java.security.SecureRandom;

public class Routes {

    public static String baseUrl = "https://petstore.swagger.io/v2";

    // User model
    public static String userPost_url = baseUrl + "/user";
    public static String userGet_url = baseUrl + "/user/{username}";
    public static String userUpdate_url = baseUrl + "/user/{username}";
    public static String userDelete_url = baseUrl + "/user/{username}";

    // store module to add, find, delete, return order
    public static String orderPost_url = baseUrl + "/store/order";
    public static String orderGet_url = baseUrl + "/store/order/{orderId}";
    public static String orderDelete_url = baseUrl + "/store/order/{orderId}";
    public static String inventory_url = baseUrl + "/store/inventory";


    // pet module
    public static String petPost_url = baseUrl + "/pet";
    public static String petGet_url = baseUrl + "/pet/{petId}";
    public static String petUpdate_url = baseUrl + "";
    public static String petDelete_url = baseUrl + "/pet/{petId}";
}
