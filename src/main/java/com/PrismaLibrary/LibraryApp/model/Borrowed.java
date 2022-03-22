package com.PrismaLibrary.LibraryApp.model;

import java.util.Date;

public class Borrowed {

    private String borrower;
    private String borrowedBook;
    private Date borrowedFrom;
    private Date borrowedTo;

    public Borrowed(String borrower, String borrowedBook, Date borrowedFrom, Date borrowedTo) {
        this.borrower = borrower;
        this.borrowedBook = borrowedBook;
        this.borrowedFrom = borrowedFrom;
        this.borrowedTo = borrowedTo;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(String borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public Date getBorrowedFrom() {
        return borrowedFrom;
    }

    public void setBorrowedFrom(Date borrowedFrom) {
        this.borrowedFrom = borrowedFrom;
    }

    public Date getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(Date borrowedTo) {
        this.borrowedTo = borrowedTo;
    }

    @Override
    public String toString() {
        return "Borrowed{" +
                "borrower='" + borrower + '\'' +
                ", borrowedBook='" + borrowedBook + '\'' +
                ", borrowedFrom=" + borrowedFrom +
                ", borrowedTo=" + borrowedTo +
                '}';
    }
}
