package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SelectMenuPage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getWidgetsPage();
        new SidePanel(driver).selectSelectMenu();
    }

    @Test
    public void clickOnOldStyleSelectMenuTest() {
        new SelectMenuPage(driver).clickOnOldStyle("Purple");
    }

    @Test
    public void clickOnMultiselectDropDown() {
        new SelectMenuPage(driver).clickOnMultiSelectDropDown("Red").deselect();
        new SelectMenuPage(driver).chooseMultiSelectOptions("Blue","Green");
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(driver).chooseStandardMultiSelect();
    }
}
