package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public class ListAvailableBooksCommand implements Command {

    public String execute(BooksManager booksManager)
    {
        return "list";
    }
}
