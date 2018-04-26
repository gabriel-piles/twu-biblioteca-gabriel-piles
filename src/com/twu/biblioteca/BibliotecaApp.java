package com.twu.biblioteca;

import java.util.List;
import java.util.Map;
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

        if (!stringIsAInteger(optionSelected))
        {
            return continueProgram;
        }


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

        Map<Integer, String> menu = Menu.getMenu();

        for (Map.Entry<Integer, String> eachOptionMenu : menu.entrySet()) {

            System.out.println(eachOptionMenu.getKey() + " " + eachOptionMenu.getValue());

        }

        System.out.println();
    }

    public static boolean stringIsAInteger(String objectiveString) {
        try
        {
            Integer.parseInt(objectiveString);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }

        return true;
    }
}
