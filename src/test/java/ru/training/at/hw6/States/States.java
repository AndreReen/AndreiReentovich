package ru.training.at.hw6.States;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;
import ru.training.at.hw6.entities.User;

import static ru.training.at.hw6.PageObjects.JdiSite.*;

public class States {
    private static void onSite() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/"))
            homePage.open();
    }
    @Step
    public static void shouldBeLoggedIn() {
        onSite();
        if (!userName.isDisplayed())
            login();
    }
    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(new User(), "enter");
    }
}
