package com.telran.demoqa.tests;

import com.telran.demoqa.pages.ButtonsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getElementsPage();
        new SidePanel(driver).selectButtons();
    }

    @Test
    public void doubleClickTest() {
        new ButtonsPage(driver).doubleClick().isDoubleClickTextDisplayed("You have done a double click");
    }

    @Test
    public void rightClickTest() {
        new ButtonsPage(driver).rightClick().isRightClickTextDisplayed("You have done a right click");
    }
}
