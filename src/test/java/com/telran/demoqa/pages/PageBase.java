package com.telran.demoqa.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void closeBanner() {
        driver.findElement(By.id("close-fixedban")).click();
    }

    public void shouldHaveText(WebElement element, String text, int time) {
        new WebDriverWait(driver,time).until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x  + "," + y + ")");
        element.click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String pathToFile) {

        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);

        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void typeWithJS(WebElement element, int x, int y, String text) {
        if (text != null) {
            clickWithJSExecutor(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    public void hideAd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('adplus-anchor').style.display='none'");
    }
}
