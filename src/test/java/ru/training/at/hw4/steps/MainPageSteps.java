package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw4.driverutils.DriverManager;
import ru.training.at.hw4.pages.MainPage;

public class MainPageSteps extends CommonSteps {
    MainPage mainPage;

    public MainPageSteps(WebDriver webDriver) {
        super(webDriver);
        mainPage = new MainPage(webDriver);
    }

    @Step("Assert header menu size")
    public void assertHeaderMenuSize(int expected) {
        Assert.assertEquals(mainPage.headerMenuSize(), expected);
    }

    @Step("Assert header menu text")
    public void assertHeaderMenuTexts(String item1, String item2, String item3, String item4) {
        Assert.assertEquals(mainPage.headerMenuItemText(0), item1);
        Assert.assertEquals(mainPage.headerMenuItemText(1), item2);
        Assert.assertEquals(mainPage.headerMenuItemText(2), item3);
        Assert.assertEquals(mainPage.headerMenuItemText(3), item4);
    }

    @Step("Assert benefits images")
    public void assertBenefitImages(int expected) {
        Assert.assertEquals(mainPage.imageCount(), expected);
    }

    @Step("Assert benefits text")
    public void assertBenefitText(int expected, String text1, String text2,
                                  String text3, String text4) {
        Assert.assertEquals(mainPage.textCount(), expected);
        Assert.assertEquals(mainPage.textGet(0), text1);
        Assert.assertEquals(mainPage.textGet(1), text2);
        Assert.assertEquals(mainPage.textGet(2), text3);
        Assert.assertEquals(mainPage.textGet(3), text4);
    }


    @Step("Assert iframe")
    public void assertIframe() {
        Assert.assertTrue(mainPage.frameItem().isDisplayed());
    }

    @Step("Switch to IFrame")
    public void switchToFrame() {
        DriverManager.driver.switchTo().frame("frame");
    }

    @Step("Assert button is displayed")
    public void asssertButton() {
        Assert.assertTrue(mainPage.frameButtonItem().isDisplayed());
    }

    @Step("Switch to original window")
    public void switchToMain() {
        DriverManager.driver.switchTo().defaultContent();
    }

    @Step("Assert left nav menu")
    public void assertLeftNavMenu(int expected, String item1, String item2, String item3, String item4, String item5) {
        Assert.assertEquals(mainPage.leftNavMenuSize(), expected);
        Assert.assertEquals(mainPage.leftNavMenuItems(0), item1);
        Assert.assertEquals(mainPage.leftNavMenuItems(1), item2);
        Assert.assertEquals(mainPage.leftNavMenuItems(2), item3);
        Assert.assertEquals(mainPage.leftNavMenuItems(3), item4);
        Assert.assertEquals(mainPage.leftNavMenuItems(4), item5);

    }
}

