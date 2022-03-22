package com.PrismaLibrary.LibraryApp.services;

import com.PrismaLibrary.LibraryApp.model.Book;
import com.PrismaLibrary.LibraryApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    Map<String, User> userMap;

    @Autowired
    Map<String, Book> bookMap;


    public Set<String> getBorrowingUsers() {
        HashSet<String> userSet = new HashSet<String>();
        for (Map.Entry<String, User> user : userMap.entrySet()) {
            if (!user.getValue().getBorrowedList().isEmpty()) {
                userSet.add(user.getKey());
            }
        }
        return userSet;
    }

    //Partially Complete
    public List<String> getNonTerminatedUsersWithoutBook() {
        List<String> nonTerminatedUserWithoutBook = new ArrayList<>();

        for (Map.Entry<String, User> user : userMap.entrySet()) {
            if (!user.getValue().getBorrowedList().isEmpty() && user.getValue().getMemberTill() != null) {

            }
        }
        return nonTerminatedUserWithoutBook;

    }

}
