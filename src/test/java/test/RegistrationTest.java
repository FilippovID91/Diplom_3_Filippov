package test;

import data.DataUser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import page_object.PageAuthorisation;
import page_object.PageRegistration;
import pageobject.PageConstructor;

import static data.DataUser.*;
import static user_steps.UserSteps.*;

public class RegistrationTest extends TestBase {
    private Response response;
    private String accessToken;

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Регистрация пользователя (пароль 6 символов)")
    @Description("Регистрация пользователя, авторизацияи проверка появления кнопки 'Личный кабинет'")
    public void successRegistrationTest() {
        DataUser dataUser = new DataUser(driver);
        PageRegistration pageRegistration = new PageRegistration(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        PageConstructor pageConstructor = new PageConstructor(driver);
        pageRegistration.openRegistrationPage();
        pageRegistration.registrationNewUser(dataUser.RANDOM_NAME, dataUser.RANDOM_EMAIL, dataUser.RANDOM_PASS);
        pageRegistration.clickRegistrationButton();
        pageAuthorisation.waitForLoadPageAuthorisation();
        pageAuthorisation.authorisationUser(dataUser.RANDOM_EMAIL, dataUser.RANDOM_PASS);
        pageAuthorisation.clickEnterButton();
        pageConstructor.checkingLoadPageConstructor();
        Assert.assertTrue("Кнопка 'Создать заказ' не отображается", pageConstructor.isDisplayedMakeOrderButton());

        response = loginUser(dataUser.RANDOM_NAME, dataUser.RANDOM_EMAIL, dataUser.RANDOM_PASS);
        accessToken = getUserToken(response);
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ошибки с минимальным паролем (до 6и символов)")
    @Description("Под полем ввода пароля должно появиться уведомление 'Некорректный пароль'")
    public void unsuccessfulRegistrationWithSmallPasswordTest() {
        PageRegistration pageRegistration = new PageRegistration(driver);
        pageRegistration.openRegistrationPage();
        pageRegistration.registrationNewUser(RANDOM_NAME, RANDOM_EMAIL, passwordFiveCharacters);
        pageRegistration.clickRegistrationButton();
        Assert.assertTrue("Сообщение об ошибке 'Некорректный пароль' не появилось", pageRegistration.isDisplayedRegistrationErrorMessage());
    }
}