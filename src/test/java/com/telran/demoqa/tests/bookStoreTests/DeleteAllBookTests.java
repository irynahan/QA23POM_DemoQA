package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.data.BookData;
import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.*;
import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import com.telran.demoqa.pages.bookStorePages.LoginPage;
import com.telran.demoqa.pages.bookStorePages.ProfilePage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAllBookTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getBookStore().pause(1000);
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).closeBanner();
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD);
        new BookStorePage(driver).addTwoBooks();
        new SidePanel(driver).getProfile();
    }

    @Test
    public void deleteAllBookFromProfileTest() {
        new ProfilePage(driver).deleteAllBook();
        new ProfilePage(driver).isBookInProfile(BookData.BOOK_NAME);
        new ProfilePage(driver).isBookInProfile(BookData.BOOK_NAME_2);
    }
}
