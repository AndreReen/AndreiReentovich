package ru.training.at.hw6.PageObjects;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

@Url("/metals-colors.html") @Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI(".summ-res")
    public static Text summRes;
    @UI(".elem-res")
    public static Text elemRes;
    @UI(".col-res")
    public static Text colorRes;
    @UI(".met-res")
    public static Text metalRes;
    @UI(".sal-res")
    public static Text vegRes;
}
