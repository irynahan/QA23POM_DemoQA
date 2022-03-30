package com.telran.demoqa.tests;

import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).login("neuer","Neuer1234!")
                .verifyUserName("neuer")
                .logout();
    }
    @Test
    public void loginPositiveWithAssertTest() {

        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login("neuer","Neuer1234!")
                .isAccountAssert("neuer")
                .logout();
    }

}
