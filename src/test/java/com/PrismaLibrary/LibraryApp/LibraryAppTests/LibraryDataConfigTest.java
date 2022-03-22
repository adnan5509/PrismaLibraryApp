package com.PrismaLibrary.LibraryApp.LibraryAppTests;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Test Methods for LibraryDataConfig Class")
public class LibraryDataConfigTest {
    @Value("${libraryApp.csv.path.user}")
    String pathUserCsvTest;

    @Value("${libraryApp.csv.path.book}")
    String pathBooksCsvTest;

    @Value("${libraryApp.csv.path.borrowed}")
    String pathBorrowedCsvTest;

    @Nested
    @DisplayName("Test if CSV files exist at the given paths")
    class testCsvExists {
        @Test
        @DisplayName("User CSV Exists Test")
        void testUserCsvExists() {
            File userCsv = new File(pathUserCsvTest);
            assertTrue(userCsv.exists());
        }

        @Test
        @DisplayName("Books CSV Exists Test")
        void testBooksCsvExists() {
            File booksCsv = new File(pathBooksCsvTest);
            assertTrue(booksCsv.exists());
        }

        @Test
        @DisplayName("Borrowed CSV Exists Test")
        void testBorrowedCsvExists() {
            File borrowed = new File(pathBorrowedCsvTest);
            assertTrue(borrowed.exists());
        }
    }

    @Nested
    @DisplayName("Test If CSV files have the expected headers in same order")
    class testCsvHeaders {
        @Test
        @DisplayName("User CSV Headers Test")
        void testUserCsvHeaders() {
            try {
                CSVReader reader = new CSVReader(new FileReader(pathUserCsvTest));
                String[] nextLine;
                nextLine = reader.readNext();
                if (nextLine != null) {
                    assertAll(
                            () -> assertEquals(nextLine[0], "Name"),
                            () -> assertEquals(nextLine[1], "First name"),
                            () -> assertEquals(nextLine[2], "Member since"),
                            () -> assertEquals(nextLine[3], "Member till"),
                            () -> assertEquals(nextLine[4], "Gender")
                    );
                } else {
                    fail();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        @DisplayName("Books CSV Headers Test")
        void testBooksCsvHeaders() {
            try {
                CSVReader reader = new CSVReader(new FileReader(pathBooksCsvTest));
                String[] nextLine;
                nextLine = reader.readNext();
                if (nextLine != null) {
                    assertAll(
                            () -> assertEquals(nextLine[0], "Title"),
                            () -> assertEquals(nextLine[1], "Author"),
                            () -> assertEquals(nextLine[2], "Genre"),
                            () -> assertEquals(nextLine[3], "Publisher")
                    );
                } else {
                    fail();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        @DisplayName("Borrowed CSV Headers Test")
        void testBorrowedCsvHeaders() {
            try {
                CSVReader reader = new CSVReader(new FileReader(pathBorrowedCsvTest));
                String[] nextLine;
                nextLine = reader.readNext();
                if (nextLine != null) {
                    assertAll(
                            () -> assertEquals(nextLine[0], "Borrower"),
                            () -> assertEquals(nextLine[1], "Book"),
                            () -> assertEquals(nextLine[2], "borrowed from"),
                            () -> assertEquals(nextLine[3], "borrowed to")
                    );
                } else {
                    fail();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
