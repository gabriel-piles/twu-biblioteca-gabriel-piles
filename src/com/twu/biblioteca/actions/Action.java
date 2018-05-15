package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public interface Action {
    public String getName();
    public void execute(BooksManager booksManager);
}
