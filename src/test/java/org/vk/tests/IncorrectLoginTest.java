package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.ok.pages.LoginPage;
import org.ok.utils.User;

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
        loginPage.open().setUserData(user).enterWithClick();
        loginPage.isMessageWithIncorrectData();
    }

    public void incorrectLoginDataWithKey() {
        loginPage.open().setUserData(user).enterWithButton();
        loginPage.isMessageWithIncorrectData();
    }
}
