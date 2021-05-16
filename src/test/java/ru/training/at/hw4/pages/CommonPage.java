package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw4.driverutils.WaitActions;

import java.util.List;

public class CommonPage {
    protected WebDriver webDriver;

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
    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsItem;
    @FindBy(css = ".uui-navigation.nav > li")
    private List<WebElement> header;


    public CommonPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getTitle() {
        return  webDriver.getTitle();
    }

    public int headerMenuSize() {
        return header.size();
    }

    public String headerMenuItemText(int itemNumber) {
        return header.get(itemNumber).getText();
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


    public WebElement headerMenuItem(int itemNumber) {
        return header.get(itemNumber);
    }


    public WebElement getDifferentElementsMenuItem() {
        return differentElementsItem;
    }
}
