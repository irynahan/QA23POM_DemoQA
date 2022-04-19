package com.telran.demoqa.pages.bookStorePages;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookStorePage extends PageBase {

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
        closeBanner();
        clickWithJSExecutor(addToCollectionBtn,0,300);
        pause(1000);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(css = ".mr-2")
    List<WebElement> listOfBooks;

    @FindBy(css = ".text-left.fullButton")
    WebElement backToBookStoreBtn;

    public BookStorePage addTwoBooks() {

        listOfBooks.get(0).click();
        pause(1000);
        addToYourCollection();
        pause(1000);
        clickWithJSExecutor(backToBookStoreBtn,0,500);
        listOfBooks.get(1).click();
        pause(1000);
        addToYourCollection();

        return this;
    }
}
