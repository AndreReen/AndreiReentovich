package ru.training.at.hw6.Actions;


import io.qameta.allure.Step;
import ru.training.at.hw6.entities.User;
import static ru.training.at.hw6.PageObjects.JdiSite.*;

public class Actions {

    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(new User(), "enter");
    }

    @Step
    public static void logout() {
        if (!logout.isDisplayed())
            userIcon.click();
        logout.click();
    }
}