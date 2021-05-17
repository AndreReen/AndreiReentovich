package ru.training.at.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw4.driverutils.WaitActions;

import java.util.List;

public class MainPage extends CommonPage {

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

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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

}
