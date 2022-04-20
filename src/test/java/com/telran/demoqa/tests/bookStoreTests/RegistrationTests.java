package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import com.telran.demoqa.pages.bookStorePages.LoginPage;
import com.telran.demoqa.pages.bookStorePages.RegistrationPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getBookStorePage();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).clickOnNewUserButton();
    }

    @Test
    public void registrationNewUserPositiveTest() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        String fName = "Mery" + i;
        String lName = "Smith" + i;
        String userName = "mery" + i;
        String password = "Mery$" + i;

        new RegistrationPage(driver).fillRegistraionForm(fName,lName,userName,password).clickOnCaptcha().clickOnRegisterButton();
    }
}
