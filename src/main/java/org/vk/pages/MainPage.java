package org.ok.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage implements LoadableComponent {

    private final SelenideElement NAVIGATION_ELEMENT = $x("//*[@class='navigation']");

    private final SelenideElement MESSAGE_SECTION = $x("//*[@class='toolbar_nav_i_ic']");

    @Override
    public void checkExistense() {
        checkIsLoaded(NAVIGATION_ELEMENT);
        checkIsLoaded(MESSAGE_SECTION);
    }

    public MessagePage openMessagePage() {
        MESSAGE_SECTION.click();
        return new MessagePage();
    }

}
