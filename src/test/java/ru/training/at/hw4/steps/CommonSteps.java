package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw4.driverutils.DriverManager;
import ru.training.at.hw4.pages.CommonPage;

public class CommonSteps {
    CommonPage commonPage;

    public CommonSteps(WebDriver webDriver) {
        commonPage = new CommonPage(webDriver);
    }

    @Step("Open web page")
    public void openPage() {
        DriverManager.driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Step("Assert Browser title")
    public void assertTitle(String expected) {
        Assert.assertEquals(DriverManager.driver.getTitle(), expected);
    }

    @Step("Perform login")
    public void loggingIn(String login, String password) {
        commonPage.login(login, password);
    }

    @Step("Assert logged user name")
    public void assertUserName(String expected) {
        Assert.assertEquals(commonPage.loggedUser(), expected);
    }

    @Step("Open Different Elements Page through Service")
    public void goToDifElem() {
        commonPage.headerMenuItem(2).click();
        commonPage.getDifferentElementsMenuItem().click();
    }

}
