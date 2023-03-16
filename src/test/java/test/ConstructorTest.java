package test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends TestBase {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка перехода к разделу 'Булки'")
    @Description("Проверка перехода к разделу 'Булки' на странице Конструктор")
    public void menuBunOpenByClickTest() {
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickMenuSauce();
        pageConstructor.clickMenuBun();
        Assert.assertEquals("Булки", pageConstructor.getTextFromSelectedMenu());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка перехода к разделу 'Соусы'")
    @Description("Проверка перехода к разделу 'Соусы' на странице Конструктор")
    public void menuSauceOpenByClickTest() {
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickMenuSauce();
        Assert.assertEquals("Соусы", pageConstructor.getTextFromSelectedMenu());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка перехода к разделу 'Начинки'")
    @Description("Проверка перехода к разделу 'Начинки' на странице Конструктор")
    public void menuFillingsOpenByClickTest() {
        pageobject.PageConstructor pageConstructor = new pageobject.PageConstructor(driver);
        pageConstructor.openPageConstructor();
        pageConstructor.clickMenuFillings();
        Assert.assertEquals("Начинки", pageConstructor.getTextFromSelectedMenu());
    }
}