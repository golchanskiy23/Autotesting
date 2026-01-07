package org.ok.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class GroupsPage implements LoadableComponent {

    private static final SelenideElement INPUT_SEARCH_FIELD = Selenide.$x("//input[@role='search']");

    private static final ElementsCollection GROUP_RESULTS =
            Selenide.$$x("//div[@class='ucard-v __h group-big-card __trimmed __flex']");

    private static final SelenideElement EMPTY_PORTRAIT = Selenide.$x("//div[@class='stub-empty __v2  portlet']");

    public GroupsPage() {
        checkExistense();
    }

    @Override
    public void checkExistense() {
        checkIsLoaded(INPUT_SEARCH_FIELD);
    }

    public void findGroup(String groupName) {
        INPUT_SEARCH_FIELD.setValue(groupName);
        INPUT_SEARCH_FIELD.sendKeys(Keys.ENTER);
    }

    public long getResultGroupCount() {
        checkIsLoaded(GROUP_RESULTS);
        return GROUP_RESULTS.size();
    }

    public boolean isNotExistingGroup() {
        return EMPTY_PORTRAIT.shouldBe(Condition.visible).exists();
    }
}
