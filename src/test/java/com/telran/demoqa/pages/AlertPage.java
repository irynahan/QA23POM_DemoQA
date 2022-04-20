package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertPage extends PageBase{

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertBtn;

    public AlertPage clickTimerAlertButton() {
        click(timerAlertBtn);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmBtn;

    public AlertPage clickOnAlertButtonWithChoice() {
        click(confirmBtn);
        return this;
    }

    public AlertPage clickOnConfirmButton(String text) {
        if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        } else if (text != null && text.equals("Ok")) {
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(xpath = "//span[.='You selected Cancel']")
    WebElement confirmResult;

    public String getConfirmResult() {
      return confirmResult.getText();
    }

    @FindBy(id = "promtButton")
    WebElement promtBtn;

    public AlertPage clickOnMessageAlertButton() {
        click(promtBtn);
        return this;
    }

    public AlertPage sendTextToAlert(String message) {
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
        }
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promtResult;

    public String getConfirmMessageResult() {
        return promtResult.getText();
    }
}
