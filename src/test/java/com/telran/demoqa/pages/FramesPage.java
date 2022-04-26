package com.telran.demoqa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramesPage extends PageBase{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public FramesPage getListOfIframes() {

        //By executing JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());

        System.out.println("Number of iframes on the page are " + numberOfIframes);

        //By finding all the web elements using iframe tag
        System.out.println("Total number of iframes are " + iframes.size());
        return this;
    }

    public FramesPage switchToIframeByIndex(int index) {

        //switch to index
        driver.switchTo().frame(index);
        return this;
    }

    public FramesPage switchToIframeByID() {

        //switch to iframe by ID
        driver.switchTo().frame("frame1");

        //return to main page
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramesPage getTextFromIframe() {

        driver.switchTo().frame(frame1);

        String iframe1Text = sampleHeading.getText();
        System.out.println("Text of the frame1 heading is: " + iframe1Text);

        return this;
    }
}