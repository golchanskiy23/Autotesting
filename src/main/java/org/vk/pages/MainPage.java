package org.ok.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage implements LoadableComponent {

    private final SelenideElement NAVIGATION_ELEMENT = $x("//*[@class='navigation']");

    private final SelenideElement MESSAGE_SECTION = $x("//*[@class='toolbar_nav_i_ic']");

    private static final SelenideElement GROUPS_SECTION = $x("//a[@data-l='t,userAltGroup']");

    public MainPage() {
        checkExistense();
    }

    @Override
    public void checkExistense() {
        checkIsLoaded(NAVIGATION_ELEMENT);
        checkIsLoaded(MESSAGE_SECTION);
    }

    public MessagePage openMessagePage() {
        MESSAGE_SECTION.click();
        return new MessagePage();
    }

    public GroupsPage openGroupsPage() {
        GROUPS_SECTION.click();
        return new GroupsPage();
    }

}
