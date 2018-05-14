package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public interface Command {
    public String execute(BooksManager booksManager);
}
