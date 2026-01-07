package org.ok.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.ok.pages.LoginPage;
import org.ok.utils.SupportFunctions;
import org.ok.utils.User;

public class CorrectLoginTest extends BaseTest{

    private LoginPage loginPage;
    private User user;

    @BeforeAll
    public void initializeLoginPage() {
        loginPage = new LoginPage();
        user = new User("89818562862", "licey344");
    }

    @Test
    private void correctLogin() {
        SupportFunctions.login(loginPage, user);
    }
