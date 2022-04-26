package com.telran.demoqa.tests;


import com.telran.demoqa.pages.DroppablePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.PageBase;
import com.telran.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable();
    }

    @Test
    public void dragMeWitchActionsTest() {
        new DroppablePage(driver).dragMeWithActions();
    }

    @Test
    public void dragMeByTest() {
        new DroppablePage(driver).dragMeBy();
    }

    @Test
    public void dragMeByNumberTest() {
        new DroppablePage(driver).dragMeByPosition();
    }

    @Test
    public void dragAcceptableOneElementPositiveTest(){
        new DroppablePage(driver).goToAcceptTab();
        new DroppablePage(driver).dragAcceptableElement();
        Assert.assertEquals(new DroppablePage(driver).getAcceptableResaltText(), "Dropped!");
    }

    @Test
    public void dragAcceptableTwoElementPositiveTest(){
        new DroppablePage(driver).goToAcceptTab();
        new DroppablePage(driver).dragAcceptableElement();
        new DroppablePage(driver).dragNotAcceptableElement();
        Assert.assertEquals(new DroppablePage(driver).getAcceptableResaltText(), "Dropped!");
    }

    @Test
    public void dragNotAcceptableElementPositiveTest(){
        new DroppablePage(driver).goToAcceptTab();
        new DroppablePage(driver).dragNotAcceptableElement();
        Assert.assertEquals(new DroppablePage(driver).getAcceptableResaltText(), "Drop here");
    }

}
