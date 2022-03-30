package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

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

}
