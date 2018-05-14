package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public class QuitAction implements Action {

    @Override
    public String getId() {
        return "6";
    }

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public String execute(BooksManager booksManager)
    {
        return null;
    }
}
