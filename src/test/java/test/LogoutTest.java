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

public class LogoutTest extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Выход пользователя из профиля по кнопке 'Выход'")
    @Description("Проверка выхода пользователя из профиля по кнопке 'Выход'")
    public void authorisationByAccountButtonFromConstructorPageTest() {
        DataUser dataUser = new DataUser(driver);
        PageAccount pageAccount = new PageAccount(driver);
        PageAuthorisation pageAuthorisation = new PageAuthorisation(driver);
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageAuthorisation.openAuthorisationPage();
        pageAuthorisation.authorisationUser(dataUser.emailTestUser, dataUser.passwordTestUser);
        pageAuthorisation.clickEnterButton();
        pageConstructor.clickProfileButton();
        pageAccount.clickLogoutButton();
        Assert.assertTrue("Выход пользователя из профиля не выполнен", pageConstructor.isDisplayedMakeOrderButton());
    }
}
