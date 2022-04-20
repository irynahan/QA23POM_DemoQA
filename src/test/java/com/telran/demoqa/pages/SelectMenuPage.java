package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class SelectMenuPage extends PageBase{

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenuArrow;

    public SelectMenuPage clickOnOldStyle(String color) {

        Select select = new Select(oldSelectMenuArrow);
        select.selectByVisibleText(color);
        List<WebElement> options = select.getOptions();

        System.out.println(select.getFirstSelectedOption().getText() + "<-----It is first");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(xpath = "//html")
    WebElement space;

    public SelectMenuPage clickOnMultiSelectDropDown(String color) {
        clickWithJSExecutor(multiSelectDropDown,0,300);

        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']",color)));
        click(element);
        click(space);
        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[3]")
    WebElement deselect;

    public SelectMenuPage deselect() {
        click(deselect);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement selectInputField;

    public SelectMenuPage chooseMultiSelectOptions(String color1, String color2) {
        selectInputField.sendKeys(color1);
        selectInputField.sendKeys(Keys.ENTER);
        selectInputField.sendKeys(color2);
        selectInputField.sendKeys(Keys.ENTER);
        space.click();
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public SelectMenuPage chooseStandardMultiSelect() {
        Select multi = new Select(cars);

        if (multi.isMultiple()) {
            multi.selectByIndex(1);
            multi.selectByIndex(2);
            multi.selectByIndex(3);
        }

        List<WebElement> selectedOpt = multi.getAllSelectedOptions();
        for (WebElement el: selectedOpt) {
            System.out.println(el.getText() + "<----Multi");
        }
        return this;
    }
}
