package data;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class DataUser {

    private final WebDriver driver;

    public DataUser(WebDriver driver) {
    this.driver = driver;
}
    public static String RANDOM_EMAIL = RandomStringUtils.randomAlphabetic(4) + "@" + RandomStringUtils.randomAlphabetic(4) + ".com";
    public static String RANDOM_PASS = RandomStringUtils.randomNumeric(6);
    public static String RANDOM_NAME = RandomStringUtils.randomAlphabetic(6);

    // Тестовый зарегистрированный пользователь
    public static String emailTestUser = "filippovTest@gmail.com";
    public static String passwordTestUser = "470956857";
    public static String nameTestUser = "Ivan";

    public static String passwordFiveCharacters = "12345";
}