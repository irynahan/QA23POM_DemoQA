package com.telran.demoqa.pages.bookStorePages;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement pswd;

    @FindBy(id = "login")
    WebElement loginBtn;

    public ProfilePage login(String uName, String pw) {
        type(userName,uName);
        type(pswd,pw);
        click(loginBtn);
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String uName, String pw) {
        type(userName,uName);
        type(pswd,pw);
        click(loginBtn);
        return this;
    }

    @FindBy(id = "newUser")
    WebElement newUserBtn;

    public RegistrationPage clickOnNewUserButton() {
        click(newUserBtn);
        return new RegistrationPage(driver);
    }
}
