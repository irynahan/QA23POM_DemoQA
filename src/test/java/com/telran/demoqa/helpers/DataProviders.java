package com.telran.demoqa.helpers;

import com.opencsv.CSVReader;
import com.telran.demoqa.data.Student;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newStudentFromCSV() throws IOException {
        com.opencsv.CSVReader fileReader = new CSVReader(new FileReader("src/test/resources/students_data.csv"));
        Iterator<String[]> fileReaderInterator = fileReader.iterator();
        List<Object[]> returnValue = new ArrayList<>();
        while(fileReaderInterator.hasNext()){
            String[] nextRecord = fileReaderInterator.next();
            returnValue.add(new Object[]{new Student()
                    .setFirstName(nextRecord[0])
                    .setLastName (nextRecord[1])
                    .seteMail(nextRecord[2])
                    .setPhoneNumber(nextRecord[3])
                    .setGender(nextRecord[4])
                    .setDate(nextRecord[5])
                    .setSubject(nextRecord[6].split(","))
                    .setHobbies(nextRecord[7].split(","))
                    .setPhotoUrl(nextRecord[8])
                    .setAddress(nextRecord[9])
                    .setState(nextRecord[10])
                    .setCity(nextRecord[11])});
        }
        return returnValue.iterator();
    }

}
