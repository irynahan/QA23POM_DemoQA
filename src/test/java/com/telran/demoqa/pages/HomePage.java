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

    public BookStorePage getBookStore() {
        clickWithJSExecutor(bookStoreApplicationBlock,0,300);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Alerts, Frame & Windows']")
    WebElement alertFrameAndWindow;

    public SidePanel getAlertFrameAndWindows() {
        clickWithJSExecutor(alertFrameAndWindow,0,300);
        return new SidePanel(driver);
    }
}
