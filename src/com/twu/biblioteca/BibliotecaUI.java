package com.twu.biblioteca;

import java.util.*;

public class BibliotecaUI {

    private BooksManager booksManager;

    public BibliotecaUI(BooksManager booksManager) {
        this.booksManager = booksManager;
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
            System.out.println("\nThe option " + optionSelected + " is not valid!\n\n");
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
            //checkOutBook(booksManager);
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
        String bookName = getUserInput("Write the book's name to return:");

        if(booksManager.returnBook(bookName))
        {
            System.out.println("\nThe book " + bookName + " was successfully returned\n");
        }
        else{
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
        }
    }

    private static void checkBookDetails(Map<String, Book> booksList) {

        String bookName = getUserInput("Write the book's name to get the details:");

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

    public static void printWelcomeMessage() {
        System.out.println("\nWelcome to the Bangalore Public Library\n");
    }

    public static void printDictionary(Map<String, String> genericDictionary) {

        for (Map.Entry<String, String> eachOptionMenu : genericDictionary.entrySet()) {

            System.out.println(eachOptionMenu.getKey() + " " + eachOptionMenu.getValue());
        }

        System.out.println();
    }
    
    public void printResultCheckOutBook(String nameBookCheckOut){

        if(!this.booksManager.existBook(nameBookCheckOut))
        {
            System.out.println("\nThe book " + nameBookCheckOut + " does not exist in the library\n");
            return;
        }

        Book objectiveBook = this.booksManager.getBook(nameBookCheckOut);

        if(!objectiveBook.isAvailable())
        {
            System.out.println("\nThe book " + nameBookCheckOut + " is already checked out\n");
        }
        else {
            this.booksManager.checkOutBook(nameBookCheckOut);
            System.out.println("\nThe book " + nameBookCheckOut + " was successfully checked out\n");
        }
    }
}
