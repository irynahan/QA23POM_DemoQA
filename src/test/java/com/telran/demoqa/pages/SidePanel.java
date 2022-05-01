package com.telran.demoqa.pages;

import com.telran.demoqa.pages.bookStorePages.BookStorePage;
import com.telran.demoqa.pages.bookStorePages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends PageBase {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='header-wrapper']/*[.='Book Store Application']")
    WebElement bookStoreAppBtn;

    public BookStorePage getBookStorePage() {
        clickWithJSExecutor(bookStoreAppBtn, 0, 500);
        return new BookStorePage(driver);
    }

    @FindBy(css = ".show #item-2")
    WebElement bookStoreBtn;

    public BookStorePage getBookStore() {
        clickWithJSExecutor(bookStoreBtn, 0, 500);
        return new BookStorePage(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profileBtn;

    public ProfilePage getProfile() {
        clickWithJSExecutor(profileBtn,0,300);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertPage selectAlert() {
        clickWithJSExecutor(alerts,0,300);
        return new AlertPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindowsPage selectWindows() {
        clickWithJSExecutor(browserWindows,0,300);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage selectSelectMenu() {
        clickWithJSExecutor(selectMenu,0,500);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement selectButtons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(selectButtons,0,500);
        return new ButtonsPage(driver);
    }

    public ProfilePage clickOnProfileButton() {
        clickWithJSExecutor(profileBtn,0,300);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement selectFrames;

    public FramesPage selectFrames() {
        clickWithJSExecutor(selectFrames,0,500);
        return new FramesPage(driver);
    }
    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement selectNestedFrames;

    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(selectNestedFrames,0,500);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement selectDroppable;

    public DroppablePage selectDroppable() {
        clickWithJSExecutor(selectDroppable,0,500);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Dragabble']")
    WebElement selectDragabble;

    public DragabblePage getDragabble() {
        clickWithJSExecutor(selectDragabble, 0, 500);
        return new DragabblePage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement selectPracticeForm;

    public PracticeFormPage selectPracticeForm() {
        clickWithJSExecutor(selectPracticeForm,0,200);
        return new PracticeFormPage(driver);
    }
}
