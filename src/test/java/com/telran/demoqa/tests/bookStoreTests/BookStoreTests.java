package com.telran.demoqa.tests;

import com.telran.demoqa.data.BookData;
import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.*;
import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import com.telran.demoqa.pages.bookStorePages.LoginPage;
import com.telran.demoqa.pages.bookStorePages.ProfilePage;
import com.telran.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getBookStore().pause(1000);
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD);
      //  new SidePanel(driver).getBookStore();
    }

    @Test
    public void searchBookPositiveTest() {
        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldInput(text);
        //Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));
        new ProfilePage(driver).isBookNameInProfileDisplayed(BookData.BOOK_NAME);
    }

    @Test
    public void searchBookEmptyFieldTest() {

        new BookStorePage(driver).typeInSearchFieldInput("  ");
        Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));
    }

    @Test
    public void addBookToCollectionTest() {

        new BookStorePage(driver).typeInSearchFieldInput(BookData.BOOK_NAME)
                .clickByFirstBook().closeBanner();
         new BookStorePage(driver).addToYourCollection();
//        new SidePanel(driver).clickOnProfileButton();
//        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));
         new SidePanel(driver).getProfile();

        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_NAME));
    }

    @Test
    public void deleteBookFromCollectionTest() {
        String text = "Git Pocket Guide";
        new BookStorePage(driver).typeInSearchFieldInput(BookData.BOOK_NAME).clickByFirstBook().closeBanner();
        new BookStorePage(driver).addToYourCollection();
        //         new SidePanel(driver).clickOnProfileButton();
        new SidePanel(driver).getProfile();
        new ProfilePage(driver).clickOnTrashToDeleteBook();
        Assert.assertFalse(new ProfilePage(driver).isBookInProfile(BookData.BOOK_NAME));
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
