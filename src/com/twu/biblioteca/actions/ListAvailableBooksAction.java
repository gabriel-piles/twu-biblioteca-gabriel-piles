package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public class ListAvailableBooksAction implements Action {

    @Override
    public String getId() {
        return "1";
    }

    @Override
    public String getName() {
        return "List available books";
    }

    @Override
    public String execute(BooksManager booksManager)
    {
        return "list";
    }
}
