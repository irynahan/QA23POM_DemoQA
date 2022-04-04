package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        shouldHaveText(user,uName,15);
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
}
