package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Exercise1 {

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

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerMenuItems = webDriver.findElements(By.cssSelector(".uui-navigation.nav > li"));
        assertS.assertEquals(headerMenuItems.size(), 4);
        assertS.assertEquals(headerMenuItems.get(0).getText(), "HOME");
        assertS.assertEquals(headerMenuItems.get(1).getText(), "CONTACT FORM");
        assertS.assertEquals(headerMenuItems.get(2).getText(), "SERVICE");
        assertS.assertEquals(headerMenuItems.get(3).getText(), "METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = webDriver.findElements(By.cssSelector(".icons-benefit"));
        assertS.assertEquals(benefitIcons.size(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String benefitPractise = "To include good practices\n" + "and ideas from successful\n" + "EPAM project";
        String benefitCustom = "To be flexible and\n" + "customizable";
        String benefitMulti = "To be multiplatform";
        String benefitBase = "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";

        List<WebElement> benefitTexts = webDriver.findElements(By.cssSelector(".benefit-txt"));
        assertS.assertEquals(benefitTexts.size(), 4);
        assertS.assertEquals(benefitTexts.get(0).getText(), benefitPractise);
        assertS.assertEquals(benefitTexts.get(1).getText(), benefitCustom);
        assertS.assertEquals(benefitTexts.get(2).getText(), benefitMulti);
        assertS.assertEquals(benefitTexts.get(3).getText(), benefitBase);


        //8. Assert that there is the iframe with “Frame Button” exist
        assertS.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        assertS.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String [] expectedMenuItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        int expectedMenuSize = 5;

        assertS.assertTrue(webDriver.findElement(By.name("navigation-sidebar")).isDisplayed());
        List<WebElement> leftMenuItems = webDriver.findElements(By.xpath("//*[@class='sidebar-menu left']/li"));

        assertS.assertEquals(leftMenuItems.size(), expectedMenuSize);
        for (int i = 0; i < leftMenuItems.size(); i++) {
            assertS.assertEquals(leftMenuItems.get(i).getText(), expectedMenuItems[i]);
        }

        //12. Close Browser
        webDriver.close();
        assertS.assertAll();
    }
}