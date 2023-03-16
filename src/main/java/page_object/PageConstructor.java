package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.DataURL.BASE_URL;

public class PageConstructor {

    public PageConstructor(WebDriver driver) {this.driver = driver;}
    private final WebDriver driver;

    private static final By menuBun = By.xpath("//span[text()='Булки']");
    private static final By menuFillings = By.xpath("//span[text()='Начинки']");
    private static final By menuSauce = By.xpath("//span[text()='Соусы']");
    private static final By profileButton = By.xpath("//p[text()='Личный Кабинет']");
    private static final By enterAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    private static final By currentMenu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

    @Step("Открытие главной страницы")
    public void openPageConstructor() {driver.get(BASE_URL);}

    @Step("Нажатие кнопки 'Личный кабинет'")
    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }

    @Step("Нажатие кнопки 'Войти в аккаунт'")
    public void clickAccountButton() {
        driver.findElement(enterAccountButton).click();
    }

    @Step("Нажатие на закладку - 'Булки'")
    public void clickMenuBun() {
        driver.findElement(menuBun).click();
    }

    @Step("Нажатие на закладку - 'Начинки'")
    public void clickMenuFillings() { driver.findElement(menuFillings).click(); }

    @Step("Нажатие на закладку - 'Соусы'")
    public void clickMenuSauce() {
        driver.findElement(menuSauce).click();
    }

    @Step("Проверка текста выбранного меню")
    public String getTextFromSelectedMenu() {
        return driver.findElement(currentMenu).getText();
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isDisplayedMakeOrderButton() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Проверка загрузки страницы 'Конструктор'")
    public boolean checkingLoadPageConstructor() { return driver.findElement(makeOrderButton).isDisplayed();
    }
}