package ru.training.at.hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage {

    private WebDriver webDriver;

    @FindBy(css = ".label-checkbox > input")
    private List<WebElement> checkBoxes;
    @FindBy(css = ".label-radio > input")
    private List<WebElement> radioButtons;
    @FindBy(css = ".colors > select")
    private WebElement dropDownMenu;
    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> log;



    public DifferentElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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
