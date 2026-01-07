package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.ok.pages.LoginPage;
import org.ok.utils.User;

public class IncorrectLoginTest extends BaseTest {

    LoginPage loginPage;
    User user;

    @BeforeAll
    public void initializeLoginPage() {
        loginPage = new LoginPage();
        user = new User("blsblsbsl", "blalblala");
    }

    @Test
    public void incorrectUserDataWithClick() {
        login(user)
        loginPage.enterWithClick();
        loginPage.isMessageWithIncorrectData();
    }

    @Test
    public void incorrectUserDataWithKey() {
        login(user);
        loginPage.enterWithButton();
        loginPage.isMessageWithIncorrectData();
    }

    private void login() {
        loginPage.open().setUserData(user);
    }
}
