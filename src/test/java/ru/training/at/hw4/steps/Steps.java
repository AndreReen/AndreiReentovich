package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.driverutils.DriverManager;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.testdata.TestData;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Steps extends BaseStep {
    MainPage mainPage;
    DifferentElementsPage differentElementsPage;
    SoftAssert assertS;

    //constructor
    public Steps(WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Open web page")
    public void openPage() {
        mainPage.openPage();
    }

    @Step("Assert Browser title")
    public void assertTitle(String expected) {
        Assert.assertEquals(DriverManager.driver.getTitle(), expected);
    }

    @Step("Perform login")
    public void loggingIn() {
        mainPage.login(getUserLogin(), getUserPassword());
    }

    @Step("Fetching login from properties")
    public String getUserLogin() throws NullPointerException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String testDataPath = rootPath + "testData.properties";

        Properties testProps = new Properties();
        try {
            testProps.load(new FileInputStream(testDataPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testProps.getProperty("login");
    }

    @Step("Fetching password from properties")
    public String getUserPassword() throws NullPointerException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String testDataPath = rootPath + "testData.properties";

        Properties testProps = new Properties();
        try {
            testProps.load(new FileInputStream(testDataPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testProps.getProperty("password");
    }

    @Step("Assert logged user name")
    public void assertUserName(String expected) {
        Assert.assertEquals(mainPage.loggedUser(), expected);
    }

    @Step("Assert header items and text")
    public void assertHeaderMenu(int expected) {
        Assert.assertEquals(mainPage.headerMenuSize(), expected);
        Assert.assertEquals(mainPage.headerMenuItemText(0), TestData.HEADER_ITEM_1);
        Assert.assertEquals(mainPage.headerMenuItemText(1), TestData.HEADER_ITEM_2);
        Assert.assertEquals(mainPage.headerMenuItemText(2), TestData.HEADER_ITEM_3);
        Assert.assertEquals(mainPage.headerMenuItemText(3), TestData.HEADER_ITEM_4);
    }

    @Step("Assert benefits images")
    public void assertBenefitImages(int expected) {
        Assert.assertEquals(mainPage.imageCount(), expected);
    }

    @Step("Assert benefits text")
    public void assertBenefitText(int expected) {
        Assert.assertEquals(mainPage.textCount(), expected);
        Assert.assertEquals(mainPage.textGet(0), TestData.BENEFIT_TEXT_1);
        Assert.assertEquals(mainPage.textGet(1), TestData.BENEFIT_TEXT_2);
        Assert.assertEquals(mainPage.textGet(2), TestData.BENEFIT_TEXT_3);
        Assert.assertEquals(mainPage.textGet(3), TestData.BENEFIT_TEXT_4);
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
    public void assertLeftNavMenu(int expected) {
        Assert.assertEquals(mainPage.leftNavMenuSize(), expected);
        for (int i = 0; i < mainPage.leftNavMenuSize(); i++) {
            Assert.assertEquals(mainPage.leftNavMenuItems(i), TestData.EXPECTED_MENU_ITEMS[i]);
        }
    }

    @Step("Open Different Elements Page through Service")
    public void goToDifElem() {
        mainPage.headerMenuItem(2).click();
        mainPage.getDifferentElementsMenuItem().click();
    }

    @Step("Select checkbox")
    public void selectCheckbox(int checkboxNumber) {
        differentElementsPage.getCheckBox(checkboxNumber).click();
        Assert.assertTrue(differentElementsPage.getCheckBox(checkboxNumber).isSelected());
    }

    @Step("Select radiobutton")
    public void selectRadioButton(int radioButtonNumber) {
        differentElementsPage.getRadioButton(radioButtonNumber).click();
        Assert.assertTrue(differentElementsPage.getRadioButton(radioButtonNumber).isSelected());
    }

    @Step("Select from dropdown menu")
    public void selectDropdown(String color) {
        differentElementsPage.colorDropDown(color);
    }
    
    @Step("Check log ")
    public void checkLog(String logEntry) {
        Assert.assertTrue(differentElementsPage
                .searchLog(logEntry).isDisplayed());
    }
}

