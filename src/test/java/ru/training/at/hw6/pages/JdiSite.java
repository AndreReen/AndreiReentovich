package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.forms.LoginForm;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalAndColorPage;

    @UI(".form")
    public static MetalsAndColorsForm metalAndColorForm;
    @Css("form")
    public static LoginForm loginForm;
    @Css("img#user-icon")
    public static Icon userIcon;
    @UI(".uui-navigation.nav li")
    public static Menu headerMenu;
    @Css(".profile-photo [ui=label]")
    public static UIElement userName;
    @Css(".logout")
    public static WebElement logout;
}
