package org.ok.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.ok.pages.GroupsPage;
import org.ok.pages.LoginPage;
import org.ok.utils.GroupNames;
import org.ok.utils.User;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckNotExistingGroups extends BaseTest {

    @BeforeEach
    public void initializeLoginPage() {
        user = new User("botS23AT2", "autotests2023");
        Selenide.open("https://ok.ru/");
    }

    @AfterEach
    public void restart() {
        Selenide.closeWindow();
    }

    @ParameterizedTest
    @MethodSource("getNotExistingGroups")
    public void checkNotExistenseOfGroup(String groupName) {
        LoginPage loginPage = new LoginPage();

        GroupsPage groupsPage = loginPage.setUserData(user).enterWithButton().openGroupsPage();

        groupsPage.findGroup(groupName);
        assertTrue(groupsPage.isNotExistingGroup());
    }

    private static Stream<String> getNotExistingGroups() {
        return GroupNames.notExistingGroups.stream();
    }
}
