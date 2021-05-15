package ru.training.at.hw6.PageObjects;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.entities.User;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static HomePage homePage;

    @Css("#login-form") public static Form<User> loginForm;
    @Css(".profile-photo [ui=label]") public static UIElement userName;
    @Css(".logout") public static WebElement logout;
    @Css("img#user-icon") public static UIElement userIcon;
    @UI(".sidebar-menu li") public static Menu leftMenu;


    ////
    @UI(".uui-navigation.nav li") public static Menu headerMenu;

}
