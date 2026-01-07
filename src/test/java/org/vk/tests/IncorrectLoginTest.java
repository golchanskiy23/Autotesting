package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.ok.pages.LoginPage;
import org.ok.utils.User;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IncorrectLoginTest extends BaseTest {

    @BeforeEach
    public void initializeLoginPage() {
        user = new User("user", "password");
    }

    @Test
    public void incorrectLoginWithClick() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUserData(user).enterWithClick();loginPage.open().setUserData(user).enterWithClick();
        loginPage.isMessageWithIncorrectData();
    }

    public void incorrectLoginDataWithKey() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUserData(user).enterWithButton();
        loginPage.isMessageWithIncorrectData();
    }
}
