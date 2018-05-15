package com.twu.biblioteca;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BooksManager booksManager = new BooksManager("test.txt");
        BibliotecaUI bibliotecaUI = new BibliotecaUI(booksManager);

        bibliotecaUI.initializeUI();
    }
}
