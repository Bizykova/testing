package apiNew;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestUser {
    private String url = "https://petstore.swagger.io/v2";


    @Test
    public void createUserTest() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationUnique(200));
        Integer code = 200;
        String type = "unknown";
        String message = "1";
        CreateUser createUser = new CreateUser(MockUser.getId(), MockUser.getUsername(), MockUser.getFirstName(),
                MockUser.getLastName(), MockUser.getEmail(), MockUser.getPassword(), MockUser.getPhone(), MockUser.getUserStatus());
        SuccessCreateUser successCreateUser = given()
                .body(createUser)
                .when()
                .post("/user")
                .then().log().all()
                .extract().as(SuccessCreateUser.class);
        Assertions.assertAll(
                () -> Assertions.assertEquals(code, successCreateUser.getCode()),
                () -> Assertions.assertEquals(type, successCreateUser.getType()),
                () -> Assertions.assertEquals(message, successCreateUser.getMessage())
        );
    }

    @Test
    public void getUserTest() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationUnique(200));
        CreateUser createUser = given()
                .when()
                .get("/user/VasilisaPrekrasna")
                .then().log().all()
                .extract().as(CreateUser.class);

        Assertions.assertAll(
                () -> Assertions.assertEquals(MockUser.getId(), createUser.getId()),
                () -> Assertions.assertEquals(MockUser.getUsername(), createUser.getUsername()),
                () -> Assertions.assertEquals(MockUser.getFirstName(), createUser.getFirstName()),
                () -> Assertions.assertEquals(MockUser.getLastName(), createUser.getLastName()),
                () -> Assertions.assertEquals(MockUser.getEmail(), createUser.getEmail()),
                () -> Assertions.assertEquals(MockUser.getPassword(), createUser.getPassword()),
                () -> Assertions.assertEquals(MockUser.getPhone(), createUser.getPhone()),
                () -> Assertions.assertEquals(MockUser.getUserStatus(), createUser.getUserStatus())
        );
    }

    @Test
    public void changeUsernameTest() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationUnique(200));
        Integer code = 200;
        String type = "unknown";
        String message = "2";
        CreateUser createUser = new CreateUser(MockChangeUsername.getId(), MockChangeUsername.getUsername(), MockChangeUsername.getFirstName(),
                MockChangeUsername.getLastName(), MockChangeUsername.getEmail(), MockChangeUsername.getPassword(),
                MockChangeUsername.getPhone(), MockChangeUsername.getUserStatus());
        SuccessCreateUser successCreateUser = given()
                .body(createUser)
                .when()
                .put("/user/VasilisaPrekrasna")
                .then().log().all()
                .extract().as(SuccessCreateUser.class);
        Assertions.assertAll(
                () -> Assertions.assertEquals(code, successCreateUser.getCode()),
                () -> Assertions.assertEquals(type, successCreateUser.getType()),
                () -> Assertions.assertEquals(message, successCreateUser.getMessage())
        );
    }

    @Test
    public void getChangeUserTest() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationUnique(200));
        CreateUser createUser = given()
                .when()
                .get("/user/Rusya")
                .then().log().all()
                .extract().as(CreateUser.class);

        Assertions.assertAll(
                () -> Assertions.assertEquals(MockChangeUsername.getId(), createUser.getId()),
                () -> Assertions.assertEquals(MockChangeUsername.getUsername(), createUser.getUsername()),
                () -> Assertions.assertEquals(MockChangeUsername.getFirstName(), createUser.getFirstName()),
                () -> Assertions.assertEquals(MockChangeUsername.getLastName(), createUser.getLastName()),
                () -> Assertions.assertEquals(MockChangeUsername.getEmail(), createUser.getEmail()),
                () -> Assertions.assertEquals(MockChangeUsername.getPassword(), createUser.getPassword()),
                () -> Assertions.assertEquals(MockChangeUsername.getPhone(), createUser.getPhone()),
                () -> Assertions.assertEquals(MockChangeUsername.getUserStatus(), createUser.getUserStatus())
        );
    }

    @Test
    public void deleteChangeUser() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationUnique(200));
        CreateUser createUser = given()
                .when()
                .delete("/user/Rusya")
                .then().log().all()
                .extract().as(CreateUser.class);
        // Assertions.assertEquals();
    }

    @Test
    public void checkRemoteUser() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationUnique(404));
        CreateUser createUser = given()
                .when()
                .get("/user/Rusya")
                .then().log().all()
                .extract().as(CreateUser.class);
        Assertions.assertEquals("User not found", DeleteUser.getMessage());
        System.out.println("User not found + " + DeleteUser.getMessage());
    }
}
