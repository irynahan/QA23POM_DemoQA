package com.telran.demoqa.pages;

import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStoreApplicationBlock;

    public BookStorePage getBookStorePage() {
        clickWithJSExecutor(bookStoreApplicationBlock,0,300);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Alerts, Frame & Windows']")
    WebElement alertFrameAndWindow;

    public SidePanel getAlertFrameAndWindowsPage() {
        clickWithJSExecutor(alertFrameAndWindow,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//div//h5[.='Widgets']")
    WebElement widgets;

    public SidePanel getWidgetsPage() {
        clickWithJSExecutor(widgets,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//div//h5[.='Elements']")
    WebElement elements;

    public SidePanel getElementsPage() {
        clickWithJSExecutor(elements,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactions;

    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Forms']")
    WebElement forms;

    public SidePanel getForms() {
        clickWithJSExecutor(forms,0,300);
        return new SidePanel(driver);
    }


}
