package com.telran.demoqa.data;

public class Student {
    private String firstName;
    private String lastName;
    private String eMail;
    private String phoneNumber;
    private String gender;
    private String date;
    private String[] subject;
    private String[] hobbies;
    private String photoUrl;
    private String address;
    private String state;

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    private String city;

    public Student setState(String state) {
        this.state = state;
        return this;
    }

    public Student setCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public String[] getSubject() {
        return subject;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getAddress() {
        return address;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public Student setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Student setDate(String date) {
        this.date = date;
        return this;
    }

    public Student setSubject(String[] subject) {
        this.subject = subject;
        return this;
    }

    public Student setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public Student setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }
}
