package ru.training.at.hw6.actions;


import com.epam.jdi.light.elements.composite.Form;
import io.qameta.allure.Step;
import org.testng.Assert;
import ru.training.at.hw6.entities.User;

import java.util.ArrayList;
import java.util.List;

import static ru.training.at.hw6.pages.JdiSite.*;
import static ru.training.at.hw6.pages.MetalsAndColorsPage.results;

@SuppressWarnings("ALL")
public class Actions {

    @Step
    public static void login(User user) {
        userIcon.click();
        loginForm.submit(user, "enter");
    }

    @Step
    public static void logout() {
        if (!logout.isDisplayed()) {
            userIcon.click();
        }
        logout.click();
    }

    public static void verifyResults(List<String> expectedList) {
        List<String> actResults = new ArrayList<>();
        for (org.openqa.selenium.WebElement result : results) {
            actResults.add(result.getText());
        }
        Assert.assertEquals(actResults, expectedList);
    }

    public static void selectHeaderItem(String item) {
        headerMenu.select(item);
    }

    public static void openHomePage() {
        homePage.open();
    }

    public static void fillForm(Form form, Object data) {
        form.submit(data);
    }
}