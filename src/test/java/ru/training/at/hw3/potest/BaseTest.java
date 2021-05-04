package ru.training.at.hw3.potest;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw3.driverutils.GuiceDriverManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private final Injector injector = Guice.createInjector(new GuiceDriverManager());

    @Inject
    public WebDriver webDriver;

    @BeforeClass
    public void prepareToTest() {
        injector.injectMembers(this);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

/*    @AfterClass
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }*/

}
