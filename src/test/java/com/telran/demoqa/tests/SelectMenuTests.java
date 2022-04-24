package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SelectMenuPage;
import com.telran.demoqa.pages.SidePanel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

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
        new SelectMenuPage(driver).chooseMultiSelectOptions("Blue", "Green");
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(driver).chooseStandardMultiSelect();
    }

    @Test
    public void clickOnSelectValue() {
        String selectedOption = "Group 1, option 1";
        new SelectMenuPage(driver).clickOnSelectValueDropdown(selectedOption);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=' css-1hwfws3']//div[contains(text(),'"+selectedOption+"')]")).getText(), selectedOption);
    }

    @Test
    public void clickOnSelectOne() {
        String seletedOption = "Mr.";
        new SelectMenuPage(driver).clickOnSelectOneDropdown(seletedOption);
        Assert.assertEquals(new SelectMenuPage(driver).getTextValueOfSelectOne(), seletedOption);
    }
}
