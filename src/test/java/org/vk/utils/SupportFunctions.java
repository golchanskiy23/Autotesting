package org.ok.utils;

import org.ok.pages.LoginPage;

public class SupportFunctions {

    public static void login(LoginPage loginPage, User user) {
        loginPage.open()
                .setUserData(user);
    }
}
