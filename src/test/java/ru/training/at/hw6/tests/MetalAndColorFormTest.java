package ru.training.at.hw6.tests;


import org.testng.annotations.Test;
import ru.training.at.hw6.enums.HeaderMenuItems;
import ru.training.at.hw6.actions.Actions;
import ru.training.at.hw6.data.providers.DataProviderForMetalAndColorForm;
import ru.training.at.hw6.entities.MetalsAndColors;
import ru.training.at.hw6.entities.User;
import static ru.training.at.hw6.pages.JdiSite.*;

public class MetalAndColorFormTest implements TestsInit {

    @Test(dataProviderClass = DataProviderForMetalAndColorForm.class, dataProvider = "dataFromFile")
    public void metalsColorsFormFillTest(MetalsAndColors data) {
        Actions.openHomePage();
        Actions.login(new User());
        Actions.selectHeaderItem(HeaderMenuItems.METALS_COLORS);
        Actions.fillForm(metalAndColorForm, data);
        Actions.verifyResults(MetalsAndColors.resultsList(data));
        Actions.logout();
    }
}




