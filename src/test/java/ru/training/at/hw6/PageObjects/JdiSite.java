package ru.training.at.hw6.PageObjects;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static JdiHomePage jdiHomePage;

    public static void open() {
        jdiHomePage.open();
    }
}
