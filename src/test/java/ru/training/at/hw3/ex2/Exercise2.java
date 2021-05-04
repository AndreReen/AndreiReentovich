package ru.training.at.hw3.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Exercise2 {

    @Test
    public void exerciseTest() {
        WebDriver webDriver;
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        SoftAssert assertS = new SoftAssert();

        // 1. Open test site by URl
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert browser title
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Home Page";
        assertS.assertEquals(actualTitle, expectedTitle);

        // 3. Perform login
        WebElement webElement = webDriver.findElement(By.id("user-icon"));
        webElement.click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webElement = webDriver.findElement(By.id("login-button"));
        webElement.click();

        // 4. Assert User name in the right-top side of screen that user is logged in
        String actualUser = webDriver.findElement(By.id("user-name")).getText();
        String expectedUser = "ROMAN IOVLEV";
        assertS.assertEquals(actualUser, expectedUser);

        //5. Open through the header menu Service -> Different Elements Page
        webElement = webDriver.findElement(By.linkText("DIFFERENT ELEMENTS"));
        webElement.click();

        //From earlier version of HW2 req. Using it to work with elements.
        // *8*. Check interface on Different elements page, it contains all needed elements
        List<WebElement> checkBoxes = webDriver.findElements(By.xpath("//input[@type='checkbox']"));
        assertS.assertEquals(checkBoxes.size(), 4);
        List<WebElement> radioButtons = webDriver.findElements(By.xpath("//input[@type='radio']"));
        assertS.assertEquals(radioButtons.size(), 4);
        List<WebElement> dropDown = webDriver.findElements(By.xpath("//select"));
        assertS.assertEquals(dropDown.size(), 1);
        List<WebElement> buttons = webDriver.findElements(By.xpath("//input[@type='button']"));
        assertS.assertEquals(buttons.size(), 2);

        //6. Select checkboxes
        checkBoxes.get(0).click();
        assertS.assertTrue(checkBoxes.get(0).isSelected());
        checkBoxes.get(2).click();
        assertS.assertTrue(checkBoxes.get(2).isSelected());

        //7. Select radio
        radioButtons.get(3).click();
        assertS.assertTrue(radioButtons.get(3).isSelected());

        //8. Select in dropdown
        webDriver.findElement(By.xpath("//option[contains(text(), 'Yellow')]")).click();

        //9. Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        assertS.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Wind: condition changed to true')]")).isDisplayed());
        assertS.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Water: condition changed to true')]")).isDisplayed());

        // Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        assertS.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'metal: value changed to  Selen')]")).isDisplayed());

        // Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertS.assertTrue(webDriver.findElement(By.xpath("//li[contains(text(), 'Colors: value changed to Yellow')]")).isDisplayed());

        //10. Close browser
        webDriver.close();
        assertS.assertAll();
    }
}