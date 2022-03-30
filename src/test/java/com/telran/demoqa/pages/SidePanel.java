package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends PageBase {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='header-wrapper']/*[.='Book Store Application']")
    WebElement bookStoreAppBtn;

    public BookStorePage getBookStorePage() {
        clickWithJSExecutor(bookStoreAppBtn, 0, 500);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//li[@class='btn btn-light active']/*[.='Book Store']")
    WebElement bookStoreBtn;

    public BookStorePage getBookStore() {
        clickWithJSExecutor(bookStoreBtn,0,500);
        return new BookStorePage(driver);
    }


}
