package ru.training.at.hw6.forms;


import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @UI("[name =custom_radio_odd]")
    public RadioButtons summaryOdd;

    @UI("[name =custom_radio_even]")
    public RadioButtons summaryEven;

    @UI("#elements-checklist input[type=checkbox]")
    public Checklist elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metals;

    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown vegetables;

    @UI("#submit-button")
    public static Button submitButton;

    @Override
    public void submit(MetalsAndColors data) {
        summaryOdd.select(data.getSummary()[0]);
        summaryEven.select(data.getSummary()[1]);
        elements.select(data.getElements());
        colors.select(data.getColor());
        metals.select(data.getMetals());
        vegetables.expand();
        vegetables.select(3);
        vegetables.select(data.getVegetables());
        submitButton.click();
    }
}
