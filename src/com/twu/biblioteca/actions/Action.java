package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.User;

public interface Action {
    public String getName();
    public void execute(BooksManager booksManager, User user);
}
