package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.DataURL.RECOVERY_PASSWORD_PAGE_URL;

public class PagePasswordRecovery {

    public PagePasswordRecovery(WebDriver driver) {this.driver = driver;}
    private final WebDriver driver;
    private static final By recoveryEnterButton = By.xpath("//a[text()='Войти']");

    @Step("Открытие страницы - Восстановление пароля")
    public void openRecoveryPage() {
        driver.get(RECOVERY_PASSWORD_PAGE_URL);
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickEnterButtonOnRecoveryPage() {
        driver.findElement(recoveryEnterButton).click();
    }
}