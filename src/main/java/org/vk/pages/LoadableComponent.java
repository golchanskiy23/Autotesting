package org.ok.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public interface LoadableComponent {

    default SelenideElement checkIsLoaded(SelenideElement element) {
        return element.shouldBe(Condition.exist);
    }

    void checkExistense();
}
