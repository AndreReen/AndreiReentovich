package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.driverutils.WaitActions;

import java.util.List;

public class MainPage {

    private WebDriver webDriver;
    private WaitActions waitActions;

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
    @FindBy(css = ".uui-navigation.nav > li")
    private List<WebElement> header;
    @FindBy(css = ".icons-benefit")
    private List<WebElement> images;
    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
    @FindBy(name = "navigation-sidebar")
    private WebElement leftNavMenu;
    @FindBy(css = ".sidebar-menu.left > li")
    private List<WebElement> leftNavMenuItem;
    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsItem;



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    public String getTitle() {
        return  webDriver.getTitle();
    }

    public void login(String loginP, String passwordP) {
        userLogin.click();
        name.sendKeys(loginP);
        password.sendKeys(passwordP);
        loginButton.click();
    }

    public String loggedUser() {
        return userName.getText();
    }

    public int headerMenuSize() {
        return header.size();
    }

    public String headerMenuItemText(int itemNumber) {
        return header.get(itemNumber).getText();
    }

    public WebElement headerMenuItem(int itemNumber) {
        return header.get(itemNumber);
    }

    public int imageCount() {
        return images.size();
    }

    public int textCount() {
        return texts.size();
    }

    public String textGet(int textNum) {
        return texts.get(textNum).getText().replace("\n", " ");
    }

    public WebElement frameItem() {
        return frame;
    }

    public WebElement frameButtonItem() {
        return frameButton;
    }

    public int leftNavMenuSize() {
        return leftNavMenuItem.size();
    }

    public String leftNavMenuItems(int itemNumber) {
        return leftNavMenuItem.get(itemNumber).getText();
    }

    public WebElement getDifferentElementsMenuItem() {
        return differentElementsItem;
    }
}
