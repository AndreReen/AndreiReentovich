package ru.training.at.hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw5.driverutils.WaitActions;

import java.util.List;

public class UserTablePage {
    private WebDriver webDriver;
    private WaitActions waitActions;

    public UserTablePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    @FindBy(id = "ivan")
    private WebElement vipCheckboxIvan;
    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> log;
    @FindBy(css = "table[id='user-table'] select")
    private List<WebElement> dropdownMenus;
    @FindBy(css = "table[id='user-table'] a")
    private List<WebElement> userNames;
    @FindBy(css = ".user-descr > span")
    private List<WebElement> userDescriptions;
    @FindBy(css = "input[type='checkbox'")
    private List<WebElement> checkbox;
    @FindBy(css = "tr>td:nth-child(1)")
    private List<WebElement> numbers;
    @FindBy(css = "select > option")
    private List<WebElement> dropdownOptions;


    public WebElement getVipCheckboxIvan() {
        return vipCheckboxIvan;
    }

    public WebElement searchLog(String searchEntry) {
        return webDriver.findElement(By.xpath("//li[contains(text(), '" + searchEntry + "')]"));
    }

    public int getDropdownMenuNumber() {
        return dropdownMenus.size();
    }

    public int getUsersNumber() {
        return userNames.size();
    }

    public int getDescriptionsNumber() {
        return userDescriptions.size();
    }

    public int getCheckboxNumber() {
        return checkbox.size();
    }

    public String getNumbersText(int i) {
        return numbers.get(i).getText();
    }

    public String getNamesText(int i) {
        return userNames.get(i).getText();
    }

    public String getDescriptionsText(int i) {
        return userDescriptions.get(i).getText().replace("\n", " ");
    }

    public String getDropdownOptionsText(int i) {
        return dropdownOptions.get(i).getText();
    }
}
