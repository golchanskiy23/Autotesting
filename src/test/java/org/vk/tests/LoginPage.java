package org.ok.tests;

import org.openqa.selenium.Keys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement emailField = $x("//*[@id='field_email']");

    private final SelenideElement passwordField = $x("//*[@id='field_password']");

    private final SelenideElement enterOk = $x("//*[@class='button-pro __wide']");
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage setUserData(String email, String password) {
        emailField.shouldBe(Condition.visible).setValue(email);
        passwordField.shouldBe(Condition.visible).setValue(password);
        return this;
    }

    public LoginPage enterWithClick() {
        enterOk.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginPage enterWithButton() {
        enterOk.shouldBe(Condition.visible).sendKeys(Keys.ENTER);
        return this;
    }

    public void isMessageWithIncorrectData() {
        $x("//*[@class='input-e login_error']").shouldBe(Condition.visible);
    }

}
