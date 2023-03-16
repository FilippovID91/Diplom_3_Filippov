package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.DataURL.REGISTRATION_PAGE_URL;

public class PageRegistration {

    public PageRegistration(WebDriver driver) {this.driver = driver;}
    private final WebDriver driver;

    private static final By registrationName = By.xpath("//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private static final By registrationEmail = By.xpath("//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By registrationPassword = By.xpath("//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private static final By registrationEnterButton = By.xpath("//*[text()='Войти']");
    private static final By registrationErrorMessage = By.xpath("//p[text()='Некорректный пароль']");

    @Step("Открытие страницы - Регистрация")
    public void openRegistrationPage() {
        driver.get(REGISTRATION_PAGE_URL);
    }

    @Step("Заполнение поля 'Имя' формы регистрации")
    public void setRegistrationName(String name) {
        driver.findElement(registrationName).sendKeys(name);
    }

    @Step("Заполнение поля 'Email' формы регистрации")
    public void setRegistrationEmail(String email) {
        driver.findElement(registrationEmail).sendKeys(email);
    }

    @Step("Заполнение поля 'Пароль' формы регистрации")
    public void setRegistrationPassword(String password) {
        driver.findElement(registrationPassword).sendKeys(password);
    }

    @Step("Нажатие кнопки 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickEnterButton() {
        driver.findElement(registrationEnterButton).click();
    }

    @Step("Заполнение формы регистрации: 'Имя', 'Email' и 'Пароль'")
    public void registrationNewUser(String name, String email, String password) {
        setRegistrationName(name);
        setRegistrationEmail(email);
        setRegistrationPassword(password);
    }

    @Step("Проверка отображения кнопки 'Оформить заказ' после авторизации")
    public boolean isDisplayedRegistrationErrorMessage() {
        return driver.findElement(registrationErrorMessage).isDisplayed();
    }
}