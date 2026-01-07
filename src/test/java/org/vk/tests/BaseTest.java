package org.ok.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.baseUrl = "https://ok.ru/";
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

}
