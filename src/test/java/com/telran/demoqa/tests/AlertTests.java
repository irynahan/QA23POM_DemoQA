package com.telran.demoqa.tests;

import com.telran.demoqa.pages.AlertPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertFrameAndWindows();
        new SidePanel(driver).selectAlert();
    }

    @Test
    public void waitAlertTest() {
        new AlertPage(driver).clickTimerAlertButton();
    }

    @Test
    public void cancelAlertTest() {
        new AlertPage(driver).clickOnAlertButtonWithChoice().clickOnConfirmButton("Cancel");
        Assert.assertTrue(new AlertPage(driver).getConfirmResult().contains("Cancel"));
    }

    @Test
    public void sendTextToAlertTest() {
        new AlertPage(driver).clickOnMessageAlertButton().sendTextToAlert("Hello World!");
        Assert.assertTrue(new AlertPage(driver).getConfirmMessageResult().contains("Hello World!"));
    }
}
