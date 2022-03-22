package com.PrismaLibrary.LibraryApp.model;

import java.util.List;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private boolean isBorrowed;
    List<Borrowed> borrowerList;


    public Book(String title, String author, String genre, String publisher, boolean isBorrowed, List<Borrowed> borrowerList) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.isBorrowed = isBorrowed;
        this.borrowerList = borrowerList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public List<Borrowed> getBorrowerList() {
        return borrowerList;
    }

    public void setBorrowerList(List<Borrowed> borrowerList) {
        this.borrowerList = borrowerList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", borrowerList=" + borrowerList +
                '}';
    }
}
