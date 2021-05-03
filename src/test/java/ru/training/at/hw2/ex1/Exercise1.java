package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Exercise1 {

    @Test
    public void exerciseTest() {
        WebDriver webDriver;
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        // 1. Open test site by URl
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert browser title
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "Home Page";
        Assert.assertEquals(actualTitle, expectedTitle);

        // 3. Perform login
        WebElement webElement = webDriver.findElement(By.id("user-icon"));
        webElement.click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webElement = webDriver.findElement(By.id("login-button"));
        webElement.click();

        // 4. Assert User name in the right-top side of screen that user is logged in
        webElement = webDriver.findElement(By.id("user-name"));
        String actualUser = webElement.getText();
        String expectedUser = "ROMAN IOVLEV";
        Assert.assertEquals(actualUser, expectedUser);

        // 5. Assert browser title
        actualTitle = webDriver.getTitle();
        expectedTitle = "Home Page";
        Assert.assertEquals(expectedTitle, actualTitle);

        // 6. Assert header section
        Assert.assertTrue(webDriver.findElement(By.xpath("//header//li[1]")).isDisplayed());
        Assert.assertEquals("HOME", webDriver.findElement(By.xpath("//header//li[1]")).getText());
        Assert.assertTrue(webDriver.findElement(By.xpath("//header//li[2]")).isDisplayed());
        Assert.assertEquals("CONTACT FORM", webDriver.findElement(By.xpath("//header//li[2]")).getText());
        Assert.assertTrue(webDriver.findElement(By.xpath("//header//li[3]")).isDisplayed());
        Assert.assertEquals("SERVICE", webDriver.findElement(By.xpath("//header//li[3]")).getText());
        Assert.assertTrue(webDriver.findElement(By.xpath("//header//nav/ul/li[4]")).isDisplayed());
        Assert.assertEquals("METALS & COLORS", webDriver.findElement(By.xpath("//header//nav/ul/li[4]")).getText());

        //7. Assert 4 images on index
        Assert.assertTrue(webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-practise']")).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-custom']")).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-multi']")).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-base']")).isDisplayed());

        //8.Assert that there are 4 texts on the Index Page under icons and they have proper text
        String benefitPractise = "To include good practices\n" + "and ideas from successful\n" + "EPAM project";
        String benefitCustom = "To be flexible and\n" + "customizable";
        String benefitMulti = "To be multiplatform";
        String benefitBase = "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…";

        Assert.assertEquals(webDriver.findElement(By.xpath("//span[text()='To include good practices']")).getText(), benefitPractise);
        Assert.assertEquals(webDriver.findElement(By.xpath("//span[text()='To be flexible and']")).getText(), benefitCustom);
        Assert.assertEquals(webDriver.findElement(By.xpath("//span[text()='To be multiplatform ']")).getText(), benefitMulti);
        Assert.assertEquals(webDriver.findElement(By.xpath("//span[text()='Already have good base']")).getText(), benefitBase);


        //9.Assert a text of the main headers
        SoftAssert assertS = new SoftAssert();
        Assert.assertEquals("EPAM FRAMEWORK WISHES…", webDriver.findElement(By.name("main-title")).getText());
        assertS.assertEquals("LOREM IPSUM...", webDriver.findElement(By.name("jdi-text")).getText());

        //10.Assert that there is the iframe in the center of page
        Assert.assertTrue(webDriver.getPageSource().contains("iframe"));

        //11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        webDriver.switchTo().frame("jdi-frame-site");
        Assert.assertTrue(webDriver.findElement(By.id("epam-logo")).isDisplayed());

        //12.Switch to original window back
        webDriver.switchTo().defaultContent();

        //13.Assert a text of the sub header
        Assert.assertEquals(webDriver.findElement(By.linkText("JDI GITHUB")).getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        String expectedUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);

        //15.Assert that there is Left Section
        Assert.assertTrue(webDriver.findElement(By.name("navigation-sidebar")).isDisplayed());

        //16.Assert that there is Footer
        Assert.assertTrue(webDriver.findElement(By.xpath("//footer")).isDisplayed());

        //17.Close Browser
        webDriver.close();
    }
}