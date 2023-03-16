package test;

import data.DataUser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.PageAuthorisation;
import page_object.PagePasswordRecovery;
import page_object.PageRegistration;

public class LoginTest extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Авторизация пользователя по кнопке 'Войти в аккаунт' на странице конструктора")
    @Description("Проверка работы кнопки 'Войти в аккаунт' на странице конструктора")
    public void authorisationByAccountButtonFromConstructorPageTest() {
        DataUser dataUser = new DataUser(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickAccountButton();
        pageAuthorisation.authorisationUser(dataUser.emailTestUser, dataUser.passwordTestUser);
        pageAuthorisation.clickEnterButton();
        Assert.assertTrue("Авторизация не выполнена - кнопка 'Создать заказ' не отображается", pageConstructor.checkingLoadPageConstructor());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Авторизация пользователя по кнопке 'Личный кабинет' на странице конструктора")
    @Description("Проверка работы кнопки 'Личный кабинет' на странице конструктора")
    public void authorisationByPersonalAccountFromConstructorPageTest() {
        DataUser dataUser = new DataUser(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickProfileButton();
        pageAuthorisation.authorisationUser(dataUser.emailTestUser, dataUser.passwordTestUser);
        pageAuthorisation.clickEnterButton();
        Assert.assertTrue("Авторизация не выполнена - кнопка 'Создать заказ' не отображается", pageConstructor.checkingLoadPageConstructor());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Авторизация пользователя по кнопке 'Войти' на странице регистрации")
    @Description("Проверка работы кнопки 'Войти' на странице регистрации")
    public void authorisationByEnterButtonFromRegistrationPageTest() {
        DataUser dataUser = new DataUser(driver);
        PageRegistration pageRegistration = new PageRegistration(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageRegistration.openRegistrationPage();
        pageRegistration.clickEnterButton();
        pageAuthorisation.authorisationUser(dataUser.emailTestUser, dataUser.passwordTestUser);
        pageAuthorisation.clickEnterButton();
        Assert.assertTrue("Авторизация не выполнена - кнопка 'Создать заказ' не отображается", pageConstructor.checkingLoadPageConstructor());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Авторизация пользователя по кнопке 'Войти' на странице восстановления пароля")
    @Description("Проверка работы кнопки 'Войти' на странице восстановления пароля")
    public void authorisationByEnterButtonFromRecoveryPageTest() {
        DataUser dataUser = new DataUser(driver);
        PagePasswordRecovery pagePasswordRecovery = new PagePasswordRecovery(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pagePasswordRecovery.openRecoveryPage();
        pagePasswordRecovery.clickEnterButtonOnRecoveryPage();
        pageAuthorisation.authorisationUser(dataUser.emailTestUser, dataUser.passwordTestUser);
        pageAuthorisation.clickEnterButton();
        Assert.assertTrue("Авторизация не выполнена - кнопка 'Создать заказ' не отображается", pageConstructor.checkingLoadPageConstructor());
    }
}
