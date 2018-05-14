package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public class CheckOutBookAction implements Action {

    @Override
    public String getId() {
        return "0";
    }

    @Override
    public String getName() {
        return "Check out book";
    }

    @Override
    public String execute(BooksManager booksManager)
    {
        return "check";
    }
}
