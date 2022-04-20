package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BrowserWindowsPage extends PageBase {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement newTabBtn;

    @FindBy(id = "sampleHeading")
    WebElement sampleText;

    public BrowserWindowsPage clickOnNewTabButton() {
        click(newTabBtn);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public String getTextFromNewTab() {
        return sampleText.getText();
    }

    @FindBy(id = "windowButton")
    WebElement newWindowBtn;

    public BrowserWindowsPage clickOnNewWindowButton() {
        click(newWindowBtn);

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }

    @FindBy(xpath = "//h1[.='This is a sample page']")
    WebElement samplePageText;

    public BrowserWindowsPage isSampleTextDisplayed(String text) {
        shouldHaveText(samplePageText,text,10);
        Assert.assertTrue(samplePageText.isDisplayed());
        return this;
    }
}
