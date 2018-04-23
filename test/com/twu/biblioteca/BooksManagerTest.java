package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BooksManagerTest {



    @Test
    public void get_list_of_books() {
        BooksManager book_manager = new BooksManager("test.txt");
        List<Book> all_books = book_manager.get_list_of_books();
        assertEquals(all_books.size(), 2);
    }

}
