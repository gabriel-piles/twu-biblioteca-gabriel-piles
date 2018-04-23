package com.twu.biblioteca;

import java.util.List;

public class BooksManager {

    String file_name;
    List<Book> all_books;

    public BooksManager(String file_name) {
        this.file_name = file_name;
        all_books = initialize_list_all_books(file_name);
    }

    private List<Book> initialize_list_all_books(String file_name) {

        return null;
    }

    public List<Book> get_list_of_books() {
        return null;
    }
}
