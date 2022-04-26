package com.telran.demoqa.tests;

import com.telran.demoqa.pages.DragabblePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragabbleTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).getDragabble();
    }

    @Test

    public void dragToGivenPositionTest() {
        int x = 200;
        int y = 200;
        boolean result = new DragabblePage(driver).dragElementToGivenPosition(x, y);
        Assert.assertTrue(result);
    }
}
