package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ok.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.ok.pages.MainPage;
import org.ok.utils.User;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CorrectLoginTest extends BaseTest{

    @BeforeEach
    public void initializeLoginPage() {
        user = new User("botS23AT2", "autotests");
    }

    @Test
    public void correctLogin() {
       LoginPage loginPage = new LoginPage();
       MainPage mainPage = loginPage.setUserData(user).enterWithButton();
    }
}
