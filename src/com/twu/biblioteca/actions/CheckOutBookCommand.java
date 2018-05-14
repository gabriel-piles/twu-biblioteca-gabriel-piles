package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public class CheckOutBookCommand implements Command {

    public String execute(BooksManager booksManager)
    {
        return "check";
    }
}
