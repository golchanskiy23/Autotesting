package org.ok.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ok.pages.LoginPage;
import org.ok.pages.MessagePage;
import org.ok.utils.TemplateMessages;
import org.ok.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendMessageTest extends BaseTest {

    @BeforeEach
    public void initializeLoginPage() {
        user = new User("botS23AT2", "autotests");
    }

    @Test
    public void checkSendingMessageTest() {
        LoginPage loginPage = new LoginPage();
        MessagePage messagePage = loginPage.setUserData(user).enterWithButton().openMessagePage();
        String message = TemplateMessages.HELLO_MESSAGE;
        messagePage.sendMessage(message);
        assertEquals(message, messagePage.getLastSentMessage());
    }
}
