package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.EnvConfig;

import static io.restassured.RestAssured.given;

public class UserAPI {

    private String accessToken;

    public UserAPI() {
    }

    @Step("Create user with API")
    public String createUser(String name, String email, String password) {
        RestAssured.baseURI = EnvConfig.BASE_URL;

        UserPOJO user = new UserPOJO(email, password, name);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(EnvConfig.REGISTER_API)
                .then()
                .extract()
                .response();

        if (response.statusCode() == 200) {
            this.accessToken = response.jsonPath().getString("accessToken");
        } else {
            throw new RuntimeException("Не удалось создать пользователя. Статус код: " + response.statusCode());
        }
        return this.accessToken;
    }

    @Step("Delete user with API")
    public void deleteUser(String accessToken) {
        RestAssured.baseURI = EnvConfig.BASE_URL;

        if (accessToken == null) {
            throw new RuntimeException("Токен доступа не найден.");
        }

        given()
                .header("Authorization", accessToken)
                .when()
                .delete(EnvConfig.AUTH_API)
                .then()
                .statusCode(202);
    }
}
