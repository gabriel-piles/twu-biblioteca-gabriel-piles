package com.twu.biblioteca.actions;

import com.twu.biblioteca.BooksManager;

public class QuitAction implements Action {

    @Override
    public String getName() {
        return "Quit";
    }

    @Override
    public void execute(BooksManager booksManager)
    {
        System.out.println("\nGood Bye\n");
    }
}
