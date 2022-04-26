package com.telran.demoqa.tests;


import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.NestedFramesPage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedIframesTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertFrameAndWindowsPage();
        new SidePanel(driver).selectNestedFrames();
    }

    @Test
    public void handleNestedIframesTest() {
        new NestedFramesPage(driver).handleNestedIframes();
    }

    @Test
    public void switchToParentIframeTest() {
        new NestedFramesPage(driver).switchToParentIframe();
    }

    @Test
    public void switchToMainPageTest() {
        new NestedFramesPage(driver).switchToMainPage();
    }
}
