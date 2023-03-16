package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @Before
    public void setUp() {
         // инициализация WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

 /*  @Before
    public void setUpYandex() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\cygwin64\\home\\Наталья\\Diplom_3_Filippov\\src\\main\\java\\resources\\chromedriver.exe");
       // chromedriver версии 108.0.5359.71 для Яндекс Браузера версии v.23.1.4.778 (windows)
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Ivan\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }*/

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}