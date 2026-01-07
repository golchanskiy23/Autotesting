package org.ok.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OkLoginPageTest extends BaseTest {

    LoginPage loginPage;

    @BeforeEach
    public void initializeLoginPage() {
        loginPage = new LoginPage();
    }

    @Test
    public void incorrectUserDataWithClick() {
        login();
        loginPage.enterWithClick();
        loginPage.isMessageWithIncorrectData();
    }

    @Test
    public void incorrectUserDataWithKey() {
        login();
        loginPage.enterWithButton();
        loginPage.isMessageWithIncorrectData();
    }

    private void login() {
        loginPage.open().setUserData("blablabla", "12345");
    }
