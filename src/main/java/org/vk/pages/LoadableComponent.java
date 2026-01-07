package org.ok.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebElement;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public interface LoadableComponent {

    default SelenideElement checkIsLoaded(SelenideElement element) {
        return element.shouldBe(Condition.exist);
    }

    default ElementsCollection checkIsLoaded(ElementsCollection collection) {
        return collection.shouldBe(CollectionCondition.allMatch("", WebElement::isEnabled));
    }

    void checkExistense();
}
