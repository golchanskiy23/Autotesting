package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ok.pages.LoginPage;
import org.junit.jupiter.api.TestInstance;
import org.ok.pages.MainPage;
import org.ok.utils.User;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CorrectLoginTest extends BaseTest{

    private LoginPage loginPage;
    private User user;

    @BeforeAll
    public void initializeLoginPage() {
        loginPage = new LoginPage();
        user = new User("botS23AT2", "autotests");
    }

    @Test
    public void correctLogin() {
        MainPage mainPage = loginPage.open().setUserData(user).enterWithButton();
    }
