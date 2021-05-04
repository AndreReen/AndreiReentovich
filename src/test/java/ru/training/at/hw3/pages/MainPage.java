package ru.training.at.hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.driverutils.WaitActions;

import javax.inject.Inject;
import java.util.List;

public class MainPage {
    private WaitActions waitActions;
    private WebDriver webDriver;
    SoftAssert assertS = new SoftAssert();

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;
    @FindBy(xpath = "//li[@class='sbct']")
    private List<WebElement> suggestionList;
    @FindBy(id = "user-icon")
    private WebElement userLogin;
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> header;
    @FindBy(xpath = "//span[contains(@class, 'icons-benefit')]")
    private List<WebElement> images;
    @FindBy(xpath = "//span[contains(@class, 'benefit-txt')]")
    private List<WebElement> texts;

    @Inject
    public void SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    public void openTestPage() {
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public void verifyTitle(String expectedTitle) {
        String actualTitle = webDriver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void login(String loginP, String passwordP) {
        userLogin.click();
        name.sendKeys(loginP);
        password.sendKeys(passwordP);
        loginButton.click();
    }

    public void loggedUser(String expectedUser) {
        String actualUser = userName.getText();
        assertS.assertEquals(actualUser, expectedUser);
    }

    public int headerMenuSize() {
        return header.size();
    }

    public String headerMenuItem(int itemNumber) {
        return header.get(itemNumber).getText();
    }

    public int imageCount() {
        return images.size();
    }

    public int textCount() {
        return texts.size();
    }
    public String textGet(int textNum) {
        return texts.get(textNum).getText();
    }




}
