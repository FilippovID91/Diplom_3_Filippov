package test;

import data.DataUser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.PageAccount;
import page_object.PageAuthorisation;

public class TransitionsTest extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Переход в личный кабинет пользователя со страницы конструктора (без авторизации)")
    @Description("Проверка перехода в личный кабинет пользователя со страницы конструктора без авторизации")
    public void transitionConstructorPageToAuthorisationPageTest() {
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickProfileButton();
        Assert.assertTrue("Страница авторизации не загружена", pageAuthorisation.checkingLoadPageAuthorisation());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Переход на страницу конструктора из личного кабинета по кнопке 'Конструктор'")
    @Description("Проверка перехода на страницу конструктора из личного кабинета по кнопке 'Конструктор'")
    public void transitionAccountPageToConstructorPageTest() {
        DataUser dataUser = new DataUser(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        PageAccount pageAccount = new PageAccount(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickProfileButton();
        pageAuthorisation.authorisationUser(dataUser.emailTestUser, dataUser.passwordTestUser);
        pageAuthorisation.clickEnterButton();
        pageAccount.clickConstructorButton();
        Assert.assertTrue("Страница конструктора не загружена", pageConstructor.checkingLoadPageConstructor());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Переход на страницу конструктора из личного кабинета по кнопке Логотипа компании")
    @Description("Проверка перехода на страницу конструктора из личного кабинета по кнопке Логотипа компании")
    public void transitionAccountPageToConstructorPageByLogoTest() {
        DataUser dataUser = new DataUser(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        PageAccount pageAccount = new PageAccount(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickProfileButton();
        pageAuthorisation.authorisationUser(dataUser.emailTestUser, dataUser.passwordTestUser);
        pageAuthorisation.clickEnterButton();
        pageAccount.clickLogoButton();
        Assert.assertTrue("Страница конструктора не загружена", pageConstructor.checkingLoadPageConstructor());
    }
}