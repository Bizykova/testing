package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestUser {

    String username = "test_user_test";

    private String requestBody = "{\n" +
            "  \"id\": \"1\",\n" +
            "  \"username\": \""+ username +"\",\n" +
            "  \"firstName\": \"Dasha\",\n" +
            "  \"lastName\": \"Bizukova\",\n" +
            "  \"email\": \"biziykova@gmail.com\",\n" +
            "  \"password\": \"1234\",\n" +
            "  \"phone\": \"79192346587\",\n" +
            "  \"userStatus\": \"1\" \n}";

    private String requestBodyUpdate = "{\n" +
            "  \"id\": \"1\",\n" +
            "  \"username\": \""+ username +"\",\n" +
            "  \"firstName\": \"Masha\",\n" +
            "  \"lastName\": \"Ivanova\",\n" +
            "  \"email\": \"test@gmail.com\",\n" +
            "  \"password\": \"qwerty\",\n" +
            "  \"phone\": \"79196785432\",\n" +
            "  \"userStatus\": \"1\" \n}";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
    }

    @Test
    public void findUserByUsernameNotFound() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/test_user123454321")
                .then()
                .extract().response();

        System.out.println(response.asString());

        Assertions.assertEquals(404, response.statusCode());
        Assertions.assertEquals("User not found", response.jsonPath().getString("message"));
    }

    @Test
    public void findUserByUsername() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/" + username)
                .then()
                .extract().response();

        System.out.println(response.asString());

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(username, response.jsonPath().getString("username"));
    }

    @Test
    public void createUser() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract().response();



        System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("1", response.jsonPath().getString("message"));
    }

    @Test
    public void updateUser() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBodyUpdate)
                .when()
                .put("/" + username)
                .then()
                .extract().response();



        System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("1", response.jsonPath().getString("message"));
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/" + username)
                .then()
                .extract().response();



        System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(username, response.jsonPath().getString("message"));
    }
}
