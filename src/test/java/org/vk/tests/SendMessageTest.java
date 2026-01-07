package org.ok.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ok.pages.LoginPage;
import org.ok.pages.MessagePage;
import org.ok.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendMessageTest extends BaseTest {

    private LoginPage loginPage;

    private User user;

    @BeforeEach
    public void initializeLoginPage() {
        loginPage = new LoginPage();
        user = new User("botS23AT2", "autotests");
    }

    @Test
    public void checkSendingMessageTest() {
        MessagePage messagePage = loginPage.open().setUserData(user).enterWithButton().openMessagePage();
        String message = "Hello!";
        messagePage.sendMessage(message);
        assertEquals(message, messagePage.getLastSentMessage());

    }
}
