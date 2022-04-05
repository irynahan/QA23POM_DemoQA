package com.telran.demoqa.tests;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getBookStore();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD);
      //  new SidePanel(driver).getBookStore();
    }

    @Test
    public void searchBookPositiveTest() {
        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldInput(text);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));
    }

    @Test
    public void searchBookEmptyFieldTest() {
       // String text = "  ";
        new BookStorePage(driver).typeInSearchFieldInput(" ");
        Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));
    }

    @Test
    public void addBookToCollectionTest() {
        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldInput(text).clickByFirstBook().closeBanner();
         new BookStorePage(driver).addToYourCollection();
        new SidePanel(driver).clickOnProfileButton();
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));
    }

    @Test
    public void deleteBookFromCollectionTest() {
        String text = "Git Pocket Guide";
        new BookStorePage(driver).typeInSearchFieldInput(text).clickByFirstBook().closeBanner();
        new BookStorePage(driver).addToYourCollection();
        new SidePanel(driver).clickOnProfileButton();
        new ProfilePage(driver).clickOnTrashToDeleteBook();
        Assert.assertFalse(new ProfilePage(driver).isBookInProfile(text));
    }

    @Test
    public void isBookInCollectionTest() {
        String text = "Git Pocket Guide";
        new BookStorePage(driver).typeInSearchFieldInput(text).clickByFirstBook().closeBanner();
        new BookStorePage(driver).addToYourCollection();
        new SidePanel(driver).clickOnProfileButton();
        Assert.assertTrue(new ProfilePage(driver).isBookInProfile(text));
    }
}
