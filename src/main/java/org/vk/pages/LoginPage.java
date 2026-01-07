package org.ok.pages;

import org.ok.utils.User;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    private final SelenideElement Email_Field = Selenide.$x("//*[@id='field_email']");

    private final SelenideElement Password_Field = Selenide.$x("//*[@id='field_password']");

    private final SelenideElement Transition_Button = Selenide.$x("//*[@class='button-pro __wide']");
    private final SelenideElement Incorrect_Data = Selenide.$x("//*[@class='input-e login_error']");
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage setUserData(User user) {
        Email_Field.shouldBe(Condition.visible).setValue(user.getLogin());
        Password_Field.shouldBe(Condition.visible).setValue(user.getPassword());
        return this;
    }

    public LoginPage enterWithClick() {
        Transition_Button.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginPage enterWithButton() {
        Transition_Button.shouldBe(Condition.visible).sendKeys(Keys.ENTER);
        return this;
    }

    public void isMessageWithIncorrectData() {
        Selenide.$x("//*[@class='input-e login_error']").shouldBe(Condition.visible);
        Incorrect_Data.shouldBe(Condition.visible);
    }

}
