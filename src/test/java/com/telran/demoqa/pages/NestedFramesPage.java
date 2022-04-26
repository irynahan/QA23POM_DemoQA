package com.telran.demoqa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends PageBase {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedIframes() {
        int countIframesInPage = iframes.size();
        System.out.println("Number of Iframes on the Page: " + countIframesInPage);

        //switch to frame1
        driver.switchTo().frame(frame1);

        //get the text from frame1
        String frame1Text = body.getText();
        System.out.println("Frame1 is: " + frame1Text);

        //number of iframes on the frame1
        int countIframesInFrame1 = iframes.size();
        System.out.println("Number Iframes inside the frame1: " + countIframesInFrame1);

        //switch to child iframe
        driver.switchTo().frame(0);
        String frame2Text = body.getText();
        System.out.println("Frame2 is: " + frame2Text);

        int countIframesInFrame2 = iframes.size();
        System.out.println("Number of iframes inside the frame2: " + countIframesInFrame2);

        return this;
    }

    public NestedFramesPage switchToParentIframe() {
        //switch to frame1
        driver.switchTo().frame(frame1);

        //get the text from frame1
        String frame1Text = body.getText();
        System.out.println("Frame1 is: " + frame1Text);

        //switch to child iframe
        driver.switchTo().frame(0);
        String frame2Text = body.getText();
        System.out.println("Frame2 is: " + frame2Text);

        //switch to parent iframe
        driver.switchTo().parentFrame();
        String frame1Text2 = body.getText();
        System.out.println("Frame1 is: " + frame1Text2);
        return this;
    }

    @FindBy(xpath = "//div[@class='main-header']")
    WebElement mainHeader;

    @FindBy(tagName = "p")
    WebElement childText;

    @FindBy(id = "framesWrapper")
    WebElement mainPageText;

    public NestedFramesPage switchToMainPage() {
        //find text of the page heading and print
        String pageHeading = mainHeader.getText();
        System.out.println("Page Heading is: " + pageHeading);
        //switch to parent iframe
        driver.switchTo().frame(frame1);
        String frame1Text = body.getText();
        System.out.println("Frame1 is: " + frame1Text);
        //switch to child iframe
        driver.switchTo().frame(0);
        String frame2Text = childText.getText();
        System.out.println("Frame2 is: " + frame2Text);
        //switch to default content
        driver.switchTo().defaultContent();
        System.out.println(mainPageText.getText());

        return this;
    }
}
