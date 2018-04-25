package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BooksManager booksManager = new BooksManager("test.txt") ;

        printWelcomeMessage();

        boolean continueProgram = true;

        while (continueProgram)
        {
            continueProgram = initiateAction(booksManager);
        }
    }


    private static boolean initiateAction(BooksManager booksManager) {

        printMenu();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Option number:");
        String optionSelected = scanner.nextLine();

        boolean continueProgram = true;

        if(optionSelected.equals("5"))
        {
            continueProgram = false;
        }
        else if(optionSelected.equals("1"))
        {
            System.out.println("\nList of available books:\n");
            printListOfBooks(booksManager.listAvailableBooks());

        }
        else{

            System.out.println("The option " + optionSelected + " is not valid\n\n");
        }

        return continueProgram;
    }

    private static void printListOfBooks(List<Book> booksList) {

        for(Book eachBook: booksList)
        {
            System.out.println(eachBook.getName());
        }

        System.out.println();
    }

    private static void printWelcomeMessage() {
        System.out.println("\nWelcome to the Bangalore Public Library\n");
    }

    private static void printMenu() {
        System.out.println("Options:\n");

        List<Option> menu = Menu.getMenu();
        for (Option eachOption: menu) {
            System.out.println(eachOption.getId() + " " + eachOption.getOption());
        }

        System.out.println();
    }
}
