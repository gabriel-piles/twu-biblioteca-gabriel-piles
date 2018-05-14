package com.twu.biblioteca;

import com.twu.biblioteca.actions.CheckOutBookAction;
import com.twu.biblioteca.actions.Action;
import com.twu.biblioteca.actions.ListAvailableBooksAction;

import java.util.*;

public class BibliotecaUI {

    private BooksManager booksManager;

    public BibliotecaUI(BooksManager booksManager) {
        this.booksManager = booksManager;
    }

    public void initializeUI() {
        boolean continueProgram = true;

        while (continueProgram)
        {
            printMenu();
            String optionSelected = getUserInput("Option number:");
            continueProgram = initiateAction(optionSelected);
        }
    }

    public String testCommands(int actionNumber){
        Action action = commandMap.get(actionNumber);
        return action.execute(this.booksManager);
    }

    private static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void printMenu(){
        Map<String, String> menu = Menu.getMenu();
        printDictionary(menu);
    }
    
    private boolean initiateAction(String optionSelected) {

        boolean continueProgram = true;

        Map<String, String> menu = Menu.getMenu();

        if (!menu.containsKey(optionSelected))
        {
            System.out.println("\nThe option " + optionSelected + " is not valid!\n\n");
        }
        else if(menu.get(optionSelected).equals("List Books"))
        {
            printAvailableBooks();
        }
        else if(menu.get(optionSelected).equals("Book Details"))
        {
            //checkBookDetails(booksManager.getAllBooks());
        }
        else if(menu.get(optionSelected).equals("Checkout Book"))
        {
            //checkOutBook(booksManager);
        }
        else if(menu.get(optionSelected).equals("Return Book"))
        {
            //returnBook(booksManager);
        }
        else if(menu.get(optionSelected).equals("Quit"))
        {
            System.out.println("\nGood Bye\n");
            continueProgram = false;
        }

        return continueProgram;
    }

    public void printBookDetails(String bookName) {

        if(!this.booksManager.existBook(bookName))
        {
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
            return;
        }

        Book objectiveBook = this.booksManager.getBook(bookName);

        objectiveBook.printBookDetails();
    }

    public void printAvailableBooks() {

        List<Book> booksList = this.booksManager.getBooksThatSatisfyCondition(true);

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

    private static void printDictionary(Map<String, String> genericDictionary) {

        for (Map.Entry<String, String> eachOptionMenu : genericDictionary.entrySet()) {

            System.out.println(eachOptionMenu.getKey() + " " + eachOptionMenu.getValue());
        }

        System.out.println();
    }
    
    public void printResultCheckOutBook(String bookName){

        if(!existBook(bookName))
        {
            return;
        }

        Book objectiveBook = this.booksManager.getBook(bookName);

        if(!objectiveBook.isAvailable())
        {
            System.out.println("\nThe book " + bookName + " is already checked out\n");
        }
        else {
            this.booksManager.checkOutBook(bookName);
            System.out.println("\nThe book " + bookName + " was successfully checked out\n");
        }
    }

    public void printResultReturnBook(String bookName) {
        if(!existBook(bookName))
        {
            return;
        }

        Book objectiveBook = this.booksManager.getBook(bookName);

        if(objectiveBook.isAvailable())
        {
            System.out.println("\nThe book " + bookName + " is not checked out\n");
        }
        else {
            this.booksManager.returnBook(bookName);
            System.out.println("\nThe book " + bookName + " was successfully returned\n");
        }
    }

    private boolean existBook(String bookName){

        boolean bookExistence = true;
        if(!this.booksManager.existBook(bookName))
        {
            System.out.println("\nThe book " + bookName + " does not exist in the library\n");
            bookExistence = false;
        }

        return bookExistence;
    }
}
