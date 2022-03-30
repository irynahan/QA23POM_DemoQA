package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login("neuer","Neuer1234!");
        new LoginPage(driver).pause(1000);
        new SidePanel(driver).getBookStorePage();
        new SidePanel(driver).getBookStore();
    }

    @Test
    public void searchBookPositiveTest() {
        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldInput(text);
    }
}
