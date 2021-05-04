package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class TestDataProvider {


    @DataProvider
    public static Object[][] testingSumData() {
        return new Object[][] {{1, 2, 3}, {3, 4, 7}, {5, 6, 11}};
    }

    @DataProvider
    public static Object[][] testingSubData() {
        return new Object[][] {{1, 2, -1}, {4, 3, 1}, {5, 5, 0}};
    }

    @DataProvider
    public static Object[][] testingMultData() {
        return new Object[][] {{1, 2, 2}, {3, 4, 12}, {5, 6, 30}};
    }

    @DataProvider
    public static Object[][] testingDivData() {
        return new Object[][] {{1, 2, 0}, {4, 3, 1}, {-10, 5, -2}};
    }

}
