package ru.training.at.hw6.forms;


import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.TestValues;

public class MetalsAndColorsForm extends Form<MetalsAndColorsForm> {

    @UI("[name =custom_radio_odd]")
    public RadioButtons summaryOdd;

    @UI("[name =custom_radio_even]")
    public RadioButtons summaryEven;

    @UI("#elements-checklist input[type=checkbox]")
    public Checklist elements;

    @JDropdown(root = "div[ui=dropdown]",
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
    public Button submitButton;

    public void submin() {
        submitButton.click();
    }

    public void fillForm(TestValues data) {
        summaryOdd.select(data.getSummary()[0]);
        summaryEven.select(data.getSummary()[1]);
        elements.select(data.getElements());
        colors.select(data.getColor());
        metals.select(data.getMetals());
        vegetables.expand();
        vegetables.select(3);
        vegetables.select(data.getVegetables());
    }
}
