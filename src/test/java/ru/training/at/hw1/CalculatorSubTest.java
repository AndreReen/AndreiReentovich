package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorSubTest {

    private Calculator calculator;

    @BeforeTest
    public void before() {
        calculator = new Calculator();
    }

    @Test(groups = {"allTests", "addAndSub"},
            dataProviderClass = TestDataProvider.class, dataProvider = "testingSubData")
    public void subLongTest(int var1, int var2, int expected) {
        long actual = calculator.sub(var1, var2);
        Assert.assertEquals(actual, expected);
    }

    @AfterTest
    public void after() {
        calculator = null;
    }

}
