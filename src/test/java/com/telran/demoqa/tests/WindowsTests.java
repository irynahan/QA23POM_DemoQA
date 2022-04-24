package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BrowserWindowsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertFrameAndWindowsPage();
        new SidePanel(driver).selectWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(driver).clickOnNewTabButton();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowTest() {
        new BrowserWindowsPage(driver).clickOnNewWindowButton().isSampleTextDisplayed("This is a sample page");
    }

    @Test
    public void newWindowMessageTest(){
        new BrowserWindowsPage(driver).clickOnNewWindowMessageButton();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewWindowMessageText().contains("Please share this website with your friends"));
    }
}
