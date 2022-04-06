package com.telran.demoqa.pages.bookStorePages;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement pwd;

    public RegistrationPage fillRegistraionForm(String fName, String lName, String uName, String password) {
        type(firstName, fName);
        type(lastName, lName);
        type(userName,uName);
        type(pwd,password);
        return this;
    }

    @FindBy(id = "g-recaptcha")
    WebElement captcha;

    public RegistrationPage clickOnCaptcha() {
        clickWithJSExecutor(captcha,0,200);
        return this;
    }

    @FindBy(id = "register")
    WebElement registerBtn;

    public RegistrationPage clickOnRegisterButton() {
        click(registerBtn);
        return this;
    }
}
