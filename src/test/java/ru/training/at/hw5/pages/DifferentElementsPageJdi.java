package ru.training.at.hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw5.driverutils.WaitActions;

import java.util.List;

public class DifferentElementsPageJdi {

    private WebDriver webDriver;
    private WaitActions waitActions;

    @FindBy(css = ".label-checkbox > input")
    private List<WebElement> checkBoxes;
    @FindBy(css = ".label-radio > input")
    private List<WebElement> radioButtons;
    @FindBy(css = ".colors > select")
    private WebElement dropDownMenu;
    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> log;

    public DifferentElementsPageJdi(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    public void openPage() {
        webDriver.get("https://jdi-testing.github.io/jdi-light/different-elements.html");
    }

    public String getTitle() {
        return  webDriver.getTitle();
    }

    public WebElement getCheckBox(int checkBoxNumber) {
        return checkBoxes.get(checkBoxNumber);
    }

    public WebElement getRadioButton(int radioButtonNumber) {
        return radioButtons.get(radioButtonNumber);
    }

    public WebElement getDropDownMenu() {
        return dropDownMenu;
    }

    public void colorDropDown(String color) {
        Select colorDropdown = new Select(dropDownMenu);
        colorDropdown.selectByVisibleText(color);
    }

    public WebElement searchLog(String searchEntry) {
        return webDriver.findElement(By.xpath("//li[contains(text(), '" + searchEntry + "')]"));
    }

    public WebElement logEntry(int logEntryNumber) {
        return log.get(logEntryNumber);
    }

    public int logSize() {
        return log.size();
    }
}
