package ru.training.at.hw3.potest;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.training.at.hw3.driverutils.DriverManager;


public class BaseTest {

    public WebDriver webDriver;

    @BeforeClass
    public void prepareToTest() {
        //Using our singleton for setup
        webDriver = DriverManager.setupDriver();
        System.out.println(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
    }

    @AfterClass
    public void resetBetweenTests() {
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().refresh();
    }

    @AfterSuite
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
