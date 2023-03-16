package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.DataURL.LOGIN_PAGE_URL;

public class PageAuthorisation {

    public PageAuthorisation(WebDriver driver) {
        this.driver = driver;
    }
    private final WebDriver driver;

    private static final By loginEmail = By.xpath("//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By loginPassword = By.xpath("//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By loginRegistrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private static final By loginEnterButton = By.xpath("//*[text()='Войти']");

    @Step("Открытие страницы - Регистрация")
    public void openAuthorisationPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    @Step("Заполнение поля 'Email' формы авторизации")
    public void setAuthorisationEmail(String email) {
        driver.findElement(loginEmail).sendKeys(email);
    }

    @Step("Заполнение поля 'Пароль' формы авторизации")
    public void setAuthorisationPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    @Step("Нажатие кнопки 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(loginRegistrationButton).click();
    }

    @Step("Нажатие кнопки 'Вход'")
    public void clickEnterButton() {
        driver.findElement(loginEnterButton).click();
    }

    @Step("Заполнение формы авторизации: 'Email' и 'Пароль'")
    public void authorisationUser (String email, String password) {
        setAuthorisationEmail(email);
        setAuthorisationPassword(password);
    }

    @Step("Ожидание загрузки формы авторизации по полю 'Email'")
    public void waitForLoadPageAuthorisation() {
           new WebDriverWait(driver, Duration.ofSeconds(5))
           .until(ExpectedConditions.visibilityOfElementLocated(loginPassword));
    }

    @Step("Проверка загрузки формы авторизации по полю 'Email'")
    public boolean checkingLoadPageAuthorisation() { return driver.findElement(loginPassword).isDisplayed();
    }
}