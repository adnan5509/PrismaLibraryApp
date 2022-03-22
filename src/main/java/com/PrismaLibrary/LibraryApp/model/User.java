package com.PrismaLibrary.LibraryApp.model;

import java.util.Date;
import java.util.List;

public class User {
    private String name;
    private String firstName;
    private Date memberSince;
    private Date memberTill;
    private char gender;
    List<Borrowed> borrowedBooksList;

    public User(String name, String firstName, Date memberSince, Date memberTill, char gender, List<Borrowed> borrowedList) {
        this.name = name;
        this.firstName = firstName;
        this.memberSince = memberSince;
        this.memberTill = memberTill;
        this.gender = gender;
        this.borrowedBooksList = borrowedList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getMemberTill() {
        return memberTill;
    }

    public void setMemberTill(Date memberTill) {
        this.memberTill = memberTill;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public List<Borrowed> getBorrowedList() {
        return borrowedBooksList;
    }

    public void setBorrowedList(List<Borrowed> borrowedList) {
        this.borrowedBooksList = borrowedList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", memberSince=" + memberSince +
                ", memberTill=" + memberTill +
                ", gender=" + gender +
                ", borrowedBooksList=" + borrowedBooksList +
                '}';
    }
}
