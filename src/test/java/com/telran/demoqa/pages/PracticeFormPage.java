package com.telran.demoqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends PageBase {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement fName;

    @FindBy(id = "lastName")
    WebElement lName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String firstName, String lastName, String email, String phoneNumber) {
        type(fName, firstName);
        type(lName, lastName);
        type(userEmail, email);
        type(userNumber, phoneNumber);
        return this;
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleRb;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleRb;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement otherRb;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            maleRb.click();
        } else if (gender.equals("Female")) {
            femaleRb.click();
        } else {
            otherRb.click();
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String date) {
        clickWithJSExecutor(dateOfBirthInput, 0, 300);

        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement month;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement year;

    public PracticeFormPage chooseDate(String m, String y, String day) {
        clickWithJSExecutor(dateOfBirthInput, 0, 300);

        Select select = new Select(month);
        select.selectByVisibleText(m);

        Select select1 = new Select(year);
        select1.selectByVisibleText(y);

        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    @FindBy(id = "react-select-2-options-0")
    WebElement selectInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    public PracticeFormPage autoChooseFirstItemFromDropDown() {
        subjectsInput.sendKeys("m");
        subjectsInput.sendKeys(Keys.DOWN, Keys.ENTER);
        return this;
    }

    public PracticeFormPage autoChooseFirstItemFromDropDown1() {
        Actions actions = new Actions(driver);
        actions.keyDown(subjectsInput, Keys.SHIFT);
        actions.sendKeys("Maths");
        actions.keyUp(Keys.SHIFT);
        return this;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage chooseHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                sports.click();
            }
            if (hobbies[i].equals("Reading")) {
                reading.click();
            }
            if (hobbies[i].equals("Music")) {
                music.click();
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureBtn;

    public PracticeFormPage uploadFile(String path) {
        uploadPictureBtn.sendKeys(path);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterAddress(String address) {
        typeWithJS(currentAddress, 0, 300, address);
        pause(2000);
        return this;
    }

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "react-select-3-input")
    WebElement state1;

    public PracticeFormPage inputState(String st) {
        hideAd();
        clickWithJSExecutor(state, 0, 500);
        state1.sendKeys(st);
        state1.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submitBtn;

    public PracticeFormPage submit() {
        hideFooter();

        click(submitBtn);
        return this;
    }

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "react-select-4-input")
    WebElement city1;

    public PracticeFormPage inputCity(String c) {
        clickWithJSExecutor(city, 0, 500);
        city1.sendKeys(c);
        city1.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy (id = "example-modal-sizes-title-lg")
    WebElement formSubmitted;

    public String getFormSubmittedText() {
        driver.switchTo().window(driver.getWindowHandle());
        String textSubmit = formSubmitted.getText();
        return textSubmit;
    }

    @FindBy (id = "closeLargeModal")
    WebElement closeModalBtn;

    public void closeModalScreen() {
        closeModalBtn.click();
    }
}
