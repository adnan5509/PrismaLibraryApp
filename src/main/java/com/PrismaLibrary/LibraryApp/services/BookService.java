package com.PrismaLibrary.LibraryApp.services;

import com.PrismaLibrary.LibraryApp.model.Book;
import com.PrismaLibrary.LibraryApp.model.Borrowed;
import com.PrismaLibrary.LibraryApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    @Autowired
    Map<String, User> userMap;

    @Autowired
    Map<String, Book> bookMap;


    public List<String> getBooksInDateRange(String borrower, Date borrowedFrom, Date borrowedTo) {
        List<String> bookList = new ArrayList<>();
        if (!userMap.get(borrower).getBorrowedList().isEmpty()) {
            for (Borrowed borrowedBooks : userMap.get(borrower).getBorrowedList()) {
                if ((borrowedBooks.getBorrowedFrom().equals(borrowedFrom) || borrowedBooks.getBorrowedFrom().after(borrowedFrom)) && (borrowedBooks.getBorrowedFrom().equals(borrowedTo) || borrowedBooks.getBorrowedFrom().before(borrowedTo))) {
                    bookList.add(borrowedBooks.getBorrowedBook());
                }
            }
        }
        return bookList;
    }

}
