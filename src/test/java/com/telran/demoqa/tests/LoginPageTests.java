package com.telran.demoqa.tests;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getBookStore();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).closeBanner();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD)
                .verifyUserName("neuer").logout();
    }
    @Test
    public void loginPositiveWithAssertTest() {

        //new LoginPage(driver).closeBanner();
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD)
                .isAccountAssert("irhan")
                .logout();
    }

}
