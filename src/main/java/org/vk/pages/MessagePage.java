package org.ok.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MessagePage implements LoadableComponent {

    private final SelenideElement MESSAGE_LIST = Selenide.$x("//msg-chats-list-item");

    private final SelenideElement MESSAGE_FIELD = Selenide.$x("//div[@data-tsid='write_msg_input-input']");

    private static final SelenideElement LAST_MESSAGE = Selenide.$$x("//*[@data-tsid='message_text']").last();
    private final SelenideElement SUBMIT_BUTTON = Selenide.$x("//msg-button[@title='Отправить']");

    @Override
    public void checkExistense() {
        checkIsLoaded(MESSAGE_FIELD);
        checkIsLoaded(MESSAGE_LIST);
        checkIsLoaded(SUBMIT_BUTTON);
    }

    public MessagePage sendMessage(String message) {
        MESSAGE_LIST.click();
        MESSAGE_FIELD.sendKeys(message);
        SUBMIT_BUTTON.click();
        return this;
    }

    public String getLastSentMessage() {
        checkIsLoaded(LAST_MESSAGE);
        return LAST_MESSAGE.getText();
    }
}
