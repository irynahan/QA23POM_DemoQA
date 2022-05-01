package com.telran.demoqa.tests;


import com.telran.demoqa.data.Student;
import com.telran.demoqa.data.StudentData;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.PracticeFormPage;
import com.telran.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void fillStudentFormPositiveTest() {
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,StudentData.EMAIL,StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
                .typeOfDate(StudentData.DATE)
                //      .chooseDate("April","2021","13");
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_URL)
                .enterAddress(StudentData.ADDRESS)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .submit();
        Assert.assertEquals(new PracticeFormPage(driver).getFormSubmittedText(), "Thanks for submitting the form");

        new PracticeFormPage(driver).closeModalScreen();
    }

    @Test (dataProvider = "newStudentFromCSV", dataProviderClass = com.telran.demoqa.helpers.DataProviders.class)
    public void fillStudentFormDataProviderPositiveTest(Student student) {
        new PracticeFormPage(driver).enterPersonalData(student.getFirstName(), student.getLastName(), student.geteMail(), student.getPhoneNumber())
                .selectGender(student.getGender())
                .typeOfDate(student.getDate())
                .addSubject(student.getSubject())
                .chooseHobby(student.getHobbies())
                .uploadFile(student.getPhotoUrl())
                .enterAddress(student.getAddress())
                .inputState(student.getState())
                .inputCity(student.getCity())
                .submit();
        Assert.assertEquals(new PracticeFormPage(driver).getFormSubmittedText(), "Thanks for submitting the form");

        new PracticeFormPage(driver).closeModalScreen();
    }
}

