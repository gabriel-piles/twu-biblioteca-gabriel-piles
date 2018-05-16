package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        ItemsManager itemsManager = new ItemsManager("book_test.txt", "movies_test.txt");
        UsersManager userManager = new UsersManager("users.txt");

        BibliotecaUI bibliotecaUI = new BibliotecaUI(itemsManager, userManager);

        bibliotecaUI.signInProcess();
    }
}
