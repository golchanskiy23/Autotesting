package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.ok.pages.LoginPage;
import org.ok.utils.User;
import org.ok.SupportFunctions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IncorrectLoginTest extends BaseTest {

    private LoginPage loginPage;
    private User user;

    @BeforeAll
    public void initializeLoginPage() {
        loginPage = new LoginPage();
        user = new User("blsblsbsl", "blalblala");
    }

    @Test
    public void incorrectLoginWithClick() {
        SupportFunctions.login(loginPage, user);
        loginPage.enterWithClick();
        loginPage.isMessageWithIncorrectData();
    }

    public void incorrectLoginDataWithKey() {
        SupportFunctions.login(loginPage, user);
        loginPage.enterWithButton();
        loginPage.isMessageWithIncorrectData();
    }
}
