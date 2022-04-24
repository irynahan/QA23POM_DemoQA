package com.telran.demoqa.pages.bookStorePages;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    @FindBy(id = "submit")
    WebElement logoutBtn;

    public ProfilePage verifyUserName(String uName) {
        if (user.getText().equals(uName)) {
            System.out.println("Correct user name: " + user.getText());
        } else {
            System.out.println("Incorrect user name: " + user.getText());
        }
        return this;
    }

    public ProfilePage isAccountAssert(String uName) {
        shouldHaveText(user, uName, 15);
        Assert.assertTrue(user.isDisplayed());
        return this;
    }

    public LoginPage logout() {
        System.out.println("Let's out from Profile");
        click(logoutBtn);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[@id='delete-record-undefined']")
    List<WebElement> bookList;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okBtn;

    public ProfilePage clickOnTrashToDeleteBook() {
        bookList.get(0).click();
        pause(2000);
        click(okBtn);
        pause(2000);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    List<WebElement> booksNameList;

    public boolean isBookInProfile(String text){
        for (WebElement book : booksNameList){
            if (book.getText().equals(text)){
                return true;
            }
        }
       return false;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;

    @FindBy(xpath = "//span[@class='mr-2']/a")
    List<WebElement> listNameOfBook;

    public ProfilePage isBookNameInProfileDisplayed(String bName) {
        shouldHaveText(nameOfBook, bName, 15);
        Assert.assertTrue(nameOfBook.isDisplayed());
        return new ProfilePage(driver);
    }

    public boolean isBookInProfileV2(String bookName) {
        for (WebElement el : listNameOfBook) {
            if (el.getText().equals(bookName)) {
                return true;
            }
        }
            return false;
    }

    @FindBy(css = ".di")
    WebElement deleteAllBookBtn;

    public ProfilePage deleteAllBook() {
        pause(1000);
        clickWithJSExecutor(deleteAllBookBtn,0,500);
        click(okBtn);
        pause(1000);
        driver.switchTo().alert().accept();
        return this;
    }
}

