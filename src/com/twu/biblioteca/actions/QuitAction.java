package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;
import com.twu.biblioteca.User;

public class QuitAction implements Action {

    @Override
    public String getName() {
        return "Quit";
    }

    @Override
    public void execute(BooksManager booksManager, User user)
    {
        System.out.println("\nGood Bye\n");
    }
}
