package com.twu.biblioteca;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        BooksManager booksManager = new BooksManager("test.txt") ;

        printWelcomeMessage();

        boolean continueProgram = true;

        Map<String, String> menu = Menu.getMenu();

        while (continueProgram)
        {
            printMenu(menu);
            String optionSelected = getSelectedOption();
            continueProgram = initiateAction(booksManager, menu, optionSelected);
        }
    }

    private static String getSelectedOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Option number:");
        return scanner.nextLine();
    }


    private static boolean initiateAction(BooksManager booksManager, Map<String, String> menu, String optionSelected) {

        boolean continueProgram = true;

        if (!menu.containsKey(optionSelected))
        {
            System.out.println("The option " + optionSelected + " is not valid\n\n");
        }
        else if(menu.get(optionSelected).equals("List Books"))
        {
            System.out.println("\nList of available books:\n");
            printListOfBooks(booksManager.listAvailableBooks());
        }
        else if(menu.get(optionSelected).equals("Quit"))
        {
            System.out.println("\nGood Bye\n");
            continueProgram = false;
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

    private static void printMenu(Map<String, String> menu) {
        System.out.println("Options:\n");

        for (Map.Entry<String, String> eachOptionMenu : menu.entrySet()) {

            System.out.println(eachOptionMenu.getKey() + " " + eachOptionMenu.getValue());

        }

        System.out.println();
    }
}
