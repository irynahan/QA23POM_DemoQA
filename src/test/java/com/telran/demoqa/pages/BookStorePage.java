package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BookStorePage extends PageBase{

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchFieldInput(String text) {
        type(searchInput,text);
        return this;
    }

    @FindBy(id = "login")
    WebElement loginBtn;

    public LoginPage clickOnLoginButton() {
        click(loginBtn);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        return nameOfBook.getText();
    }

    @FindBy(css = ".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")
    WebElement emptyField;

    public String verifyEmptyField() {
        return emptyField.getText();
    }

    public BookStorePage clickByFirstBook() {
        click(nameOfBook);
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addToCollectionBtn;

    public BookStorePage addToYourCollection() {
        clickWithJSExecutor(addToCollectionBtn,0,300);
        pause(1000);
        driver.switchTo().alert().accept();
        return this;
    }

}
