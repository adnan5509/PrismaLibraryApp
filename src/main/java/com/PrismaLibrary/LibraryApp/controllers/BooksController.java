package com.PrismaLibrary.LibraryApp.controllers;


import com.PrismaLibrary.LibraryApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/Books")
public class BooksController {

    @Autowired
    BookService bookService;

    /**
     * Task: Returns all books borrowed by a given user in a given date range
     * Sample Request URL: http://localhost:8080/v1/Books/getBooksInDateRange?borrower=Aexi,Liam&from=12/07/2011&to=01/01/2012
     */
    @GetMapping("/getBooksInDateRange")
    public List<String> getBooksInDateRange(@RequestParam("borrower") String borrower, @RequestParam("from") String borrowedFrom, @RequestParam("to") String borrowedTo) {
        Date borrowedFromDate = null;
        Date borrowedToDate = null;

        try {
            borrowedFromDate = new SimpleDateFormat("MM/dd/yyyy").parse(borrowedFrom);
            borrowedToDate = new SimpleDateFormat("MM/dd/yyyy").parse(borrowedTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bookService.getBooksInDateRange(borrower, borrowedFromDate, borrowedToDate);
    }

}
