package com.telran.demoqa.tests;


import com.telran.demoqa.pages.FramesPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getAlertFrameAndWindowsPage();
        new SidePanel(driver).selectFrames();
    }

    @Test
    public void getListOfIframesTest() {
        new FramesPage(driver).getListOfIframes();
    }

    @Test
    public void switchToIframeByIndexTest() {
        new FramesPage(driver).switchToIframeByIndex(1);
    }

    @Test
    public void switchToIframeByIDTest() {
        new FramesPage(driver).switchToIframeByID();
    }

    @Test
    public void getTextFromIframeTest() {
        new FramesPage(driver).getTextFromIframe();
    }
}


