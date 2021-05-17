package ru.training.at.hw6.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw6.Actions.Actions;
import ru.training.at.hw6.Actions.CreateDataProvider;
import ru.training.at.hw6.entities.TestValues;
import java.util.Arrays;
import static ru.training.at.hw6.PageObjects.JdiSite.*;
import static ru.training.at.hw6.PageObjects.MetalsAndColorsPage.*;

public class TheTest implements TestsInit {

    @Test(dataProviderClass = CreateDataProvider.class, dataProvider = "dataFromFile")
    public void MetalsColorsFormFillTest(TestValues data) {
        homePage.open();
        Actions.login();
        headerMenu.select("METALS & COLORS");
        macForm.fillForm(data);
        macForm.submin();
        verifyResults(data);
        Actions.logout();
    }

    public void verifyResults(TestValues data) {
        String sumExp = "Summary: " + (Integer.parseInt(data.getSummary()[0]) + Integer.parseInt(data.getSummary()[1]));
        String elemBuild = Arrays.toString(data.getElements());
        String elemExp = "Elements: " + elemBuild.substring(1, elemBuild.length() - 1);
        String colorExp = "Color: " + data.getColor();
        String metalExp = "Metal: " + data.getMetals();
        String vegBuild = Arrays.toString(data.getVegetables());
        String vegExp = "Vegetables: " + vegBuild.substring(1, vegBuild.length() - 1);

        Assert.assertEquals(summRes.getText(), sumExp);
        Assert.assertEquals(elemRes.getText(), elemExp);
        Assert.assertEquals(colorRes.getText(), colorExp);
        Assert.assertEquals(metalRes.getText(), metalExp);
        Assert.assertEquals(vegRes.getText(), vegExp);
    }
}



