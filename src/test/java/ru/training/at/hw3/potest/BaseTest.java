package ru.training.at.hw3.potest;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.driverutils.DriverManager;
import ru.training.at.hw3.entity.User;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.MainPage;

public class BaseTest {

    public WebDriver webDriver;
    public SoftAssert assertS;
    public MainPage mainPage;
    public DifferentElementsPage differentElementsPage;
    public User user;


    @BeforeClass
    public void prepareToTest() {
        webDriver = DriverManager.setupDriver();
        webDriver.manage().window().maximize();
        assertS = new SoftAssert();
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        user = new User();
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
