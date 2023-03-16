package user_steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import user_pojo.UserLogin;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserSteps {

    public Response userLogin;

    protected static Response doPostRequestWithObject (String uri, Object object) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri("https://stellarburgers.nomoreparties.site/api")
                .body(object)
                .when()
                .post(uri);
    }

    protected static Response doDeleteRequest (String uri, String accessToken) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .baseUri("https://stellarburgers.nomoreparties.site/api")
                .when()
                .delete(uri);
    }

    @Step("Авторизация пользователя с валидными данными")
    public static Response loginUser(String email, String password, String name) {
        UserLogin userLogin = new UserLogin(email, password, name);
        return doPostRequestWithObject("/auth/login", userLogin);
    }

    @Step("Получение токена авторизации пользователя")
    public static String getUserToken(Response response) {
        return response.
                then().
                extract().
                body().
                path("accessToken");
    }
    @Step("Удаление курьера по его токену")
    public static void deleteUser(String accessToken) {
        Response responseDelete = doDeleteRequest("/auth/user", accessToken);
        responseDelete.then()
                .body("success", equalTo(true))
                .and()
                .body("message", equalTo("User successfully removed"))
                .and()
                .statusCode(202);
    }
}