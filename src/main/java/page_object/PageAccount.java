package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageAccount {

    public PageAccount(WebDriver driver) {this.driver = driver;}
    private final WebDriver driver;

    private static final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private static final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private static final By logoutButton = By.xpath(".//button[text()='Выход']");

    @Step("Нажатие кнопки 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(logoButton).click();
    }

    @Step("Нажатие кнопки логотипа бургера в шапке")
    public void clickLogoButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажатие кнопки 'Выход'")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}