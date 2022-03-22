package com.PrismaLibrary.LibraryApp.controllers;


import com.PrismaLibrary.LibraryApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/Users/")
public class UsersController {
    @Autowired
    UserService userService;

    /**
     * Task: Returns all users who have actually borrowed at least one book
     * Sample Request URL: http://localhost:8080/v1/Users/getBorrowingUsers
     */
    @GetMapping("/getBorrowingUsers")
    public Set<String> getUsersWithBorrowedBook() {
        return userService.getBorrowingUsers();
    }

    /**
     * Task: Returns all non-terminated users who have not currently borrowed anything
     * Sample Request URL: http://localhost:8080/v1/Users/getNonTerminatedUsers
     */
    @GetMapping("/getNonTerminatedUsers")
    public List<String> getNonTerminatedUsersWithoutBook() {
        return userService.getNonTerminatedUsersWithoutBook();
    }


}
