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
            String optionSelected = getUserInput("Option number:");
            continueProgram = initiateAction(booksManager, menu, optionSelected);
        }
    }

    private static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }


    private static boolean initiateAction(BooksManager booksManager, Map<String, String> menu, String optionSelected) {

        boolean continueProgram = true;

        if (!menu.containsKey(optionSelected))
        {
            System.out.println("\nThe option " + optionSelected + " is not valid\n\n");
        }
        else if(menu.get(optionSelected).equals("List Books"))
        {
            printListOfBooks(booksManager.listAvailableBooks());
        }
        else if(menu.get(optionSelected).equals("Book Details"))
        {
            checkBookDetails(booksManager.getAllBooks());
        }
        else if(menu.get(optionSelected).equals("Checkout Book"))
        {
            checkOutBook(booksManager);
        }
        else if(menu.get(optionSelected).equals("Return Book"))
        {
            returnBook(booksManager);
        }
        else if(menu.get(optionSelected).equals("Quit"))
        {
            System.out.println("\nGood Bye\n");
            continueProgram = false;
        }

        return continueProgram;
    }

    private static void returnBook(BooksManager booksManager) {
        String bookName = getUserInput("Write the book name to return:");

        if(booksManager.returnBook(bookName))
        {
            System.out.println("\nThe book " + bookName + " successfully returned\n");
        }
        else{
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
        }
    }

    private static void checkOutBook(BooksManager booksManager) {

        String bookName = getUserInput("Write the book name to check out:");

        if(booksManager.checkOutBook(bookName))
        {
            System.out.println("\nThe book " + bookName + " successfully checked out\n");
        }
        else{
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
        }
    }

    private static void checkBookDetails(Map<String, Book> booksList) {

        String bookName = getUserInput("Write the book name to get the details:");

        if(booksList.containsKey(bookName))
        {
            booksList.get(bookName).printBookDetails();
        }
        else{
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
        }
    }

    private static void printListOfBooks(List<Book> booksList) {

        System.out.println("\nList of available books:\n");

        for(Book eachBook: booksList)
        {
            System.out.println("- " + eachBook.getName());
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
