package org.ok.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MessagesWrapper implements LoadableComponent {

    private static final ElementsCollection MESSAGES = Selenide.$$x("//*[@data-tsid='message_text']");


    public MessagesWrapper() {
        checkExistense();
    }

    public SelenideElement getLastMessage() {
        return MESSAGES.last();
    }

    @Override
    public void checkExistense() {
        checkIsLoaded(MESSAGES);
    }
}
