package org.ok.pages;

import org.ok.utils.User;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class LoginPage implements LoadableComponent {

    private final SelenideElement Email_Field = Selenide.$x("//*[@id='field_email']");

    private final SelenideElement Password_Field = Selenide.$x("//*[@id='field_password']");

    private final SelenideElement Transition_Button = Selenide.$x("//*[@class='button-pro __wide']");
    private final SelenideElement Incorrect_Data = Selenide.$x("//*[@class='input-e login_error']");

    public LoginPage open() {
       checkExistense();
       return this;
    }

    public LoginPage setUserData(User user) {
        Email_Field.shouldBe(Condition.visible).setValue(user.getLogin());
        Password_Field.shouldBe(Condition.visible).setValue(user.getPassword());
        return this;
    }

    public MainPage enterWithClick() {
        Transition_Button.shouldBe(Condition.visible).click();
        return new MainPage();
    }

    public LoginPage enterWithButton() {
        Transition_Button.shouldBe(Condition.visible).sendKeys(Keys.ENTER);
        return new MainPage();
    }

    public void isMessageWithIncorrectData() {
        Selenide.$x("//*[@class='input-e login_error']").shouldBe(Condition.visible);
        Incorrect_Data.shouldBe(Condition.visible);
    }

    @Override
    public void checkExistense() {
        checkIsLoaded(Email_Field);
        checkIsLoaded(Password_Field);
        checkIsLoaded(Transition_Button);
        checkIsLoaded(Incorrect_Data);
    }
}
