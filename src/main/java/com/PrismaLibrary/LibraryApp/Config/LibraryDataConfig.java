package com.PrismaLibrary.LibraryApp.Config;

import com.PrismaLibrary.LibraryApp.model.Book;
import com.PrismaLibrary.LibraryApp.model.Borrowed;
import com.PrismaLibrary.LibraryApp.model.User;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
public class LibraryDataConfig {

    @Value("${libraryApp.csv.path.user}")
    String pathUserCsv;

    @Value("${libraryApp.csv.path.book}")
    String pathBooksCsv;

    @Value("${libraryApp.csv.path.borrowed}")
    String pathBorrowedCsv;

    //    Create User Object Map with User's name as Key and contains list of Borrowed
    @Bean
    public Map<String, User> getUserDataMap() {
        Map<String, User> userMap = new HashMap<>();
        List<Borrowed> borrowedList = new ArrayList<>();

        userMap = getUsersList();
        borrowedList = getBorrowedBooksList();

        for (Borrowed borrowed : borrowedList) {
            if (userMap.containsKey(borrowed.getBorrower())) {
                userMap.get(borrowed.getBorrower()).getBorrowedList().add(borrowed);
            }
        }
        return userMap;
    }

    //    Create Books Object Map with Book Name as key and contains list of Borrowed
    @Bean
    public Map<String, Book> getBookDataMap() {
        Map<String, Book> bookMap = new HashMap<>();
        List<Borrowed> borrowedList = new ArrayList<>();
        bookMap = getBooksList();
        borrowedList = getBorrowedBooksList();

        for (Borrowed borrowed : borrowedList) {
            if (bookMap.containsKey(borrowed.getBorrowedBook()) && borrowed.getBorrowedTo().compareTo(new Date()) > 0) {
                bookMap.get(borrowed.getBorrowedBook()).setBorrowed(true);
            }
            bookMap.get(borrowed.getBorrowedBook()).getBorrowerList().add(borrowed);
        }
        return bookMap;
    }

    //    Get All Users as Map of its Objects
    public Map<String, User> getUsersList() {
        Map<String, User> userMap = new HashMap<>();

        try {
            CSVReader reader = new CSVReader(new FileReader(pathUserCsv));
            String[] nextLine;
            nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    if (!nextLine[0].isEmpty()) {
                        String name = nextLine[0];
                        String firstName = nextLine[1];
                        Date memberSince;
                        if (nextLine[2].isEmpty()) {
                            memberSince = null;
                        } else {
                            memberSince = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[2]);
                        }
                        Date memberTill;
                        if (nextLine[3].isEmpty()) {
                            memberTill = null;
                        } else {
                            memberTill = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[3]);
                        }
                        char gender = nextLine[4].charAt(0);
                        userMap.put(name + "," + firstName, new User(name, firstName, memberSince, memberTill, gender, new ArrayList<>()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMap;
    }

    //    Get All Books as Map of its Objects
    public Map<String, Book> getBooksList() {
        Map<String, Book> bookMap = new HashMap<>();

        try {
            CSVReader booksReader = new CSVReader(new FileReader(pathBooksCsv));

            String[] booksReaderLine;
            booksReaderLine = booksReader.readNext();
            while ((booksReaderLine = booksReader.readNext()) != null) {
                if (booksReaderLine != null) {
                    if (!booksReaderLine[0].isEmpty()) {
                        String title = booksReaderLine[0];
                        String author = booksReaderLine[1];
                        String genre = booksReaderLine[2];
                        String publisher = booksReaderLine[3];

                        bookMap.put(title, new Book(title, author, genre, publisher, false, new ArrayList<>()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookMap;


    }

    //    Get All Borrowed Books as List of its Objects
    public List<Borrowed> getBorrowedBooksList() {
        List<Borrowed> borrowedBooksList = new ArrayList<>();
        try {
            CSVReader borrowedReader = new CSVReader(new FileReader(pathBorrowedCsv));

            String[] borrowedBooksReaderLine;
            borrowedBooksReaderLine = borrowedReader.readNext();
            while ((borrowedBooksReaderLine = borrowedReader.readNext()) != null) {
                if (borrowedBooksReaderLine != null) {
                    if (!borrowedBooksReaderLine[0].isEmpty()) {
                        String borrower = borrowedBooksReaderLine[0];
                        String book = borrowedBooksReaderLine[1];
                        Date borrowedFrom;
                        if (borrowedBooksReaderLine[2].isEmpty()) {
                            borrowedFrom = null;
                        } else {
                            borrowedFrom = new SimpleDateFormat("MM/dd/yyyy").parse(borrowedBooksReaderLine[2]);
                        }
                        Date borrowedTo;
                        if (borrowedBooksReaderLine[3].isEmpty()) {
                            borrowedTo = null;
                        } else {
                            borrowedTo = new SimpleDateFormat("MM/dd/yyyy").parse(borrowedBooksReaderLine[3]);
                        }
                        borrowedBooksList.add(new Borrowed(borrower, book, borrowedFrom, borrowedTo));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return borrowedBooksList;

    }


}
