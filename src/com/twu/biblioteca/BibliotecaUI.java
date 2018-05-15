package com.twu.biblioteca;

import com.twu.biblioteca.actions.CheckOutBookAction;
import com.twu.biblioteca.actions.Action;
import com.twu.biblioteca.actions.ListAvailableBooksAction;

import java.util.*;

public class BibliotecaUI {

    private BooksManager booksManager;
    private Map<String, Action> menu;
    private UsersManager usersManager;
    private User authenticatedUser;

    public BibliotecaUI(BooksManager booksManager, UsersManager usersManager) {
        printWelcomeMessage();
        this.booksManager = booksManager;
        this.menu = Menu.getMenu();
        this.usersManager = usersManager;
    }

    public void initializeUI() {
        boolean continueProgram = true;

        while (continueProgram)
        {
            printMenu();
            String optionSelected = getUserInput("Option number:");

            if(!this.menu.containsKey(optionSelected)){
                System.out.println("Select a valid option\n");
                continue;
            }

            this.menu.get(optionSelected).execute(this.booksManager, null);

            if(this.menu.get(optionSelected).getName() == "Quit")
            {
                continueProgram = false;
            }
        }
    }

    public static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void printMenu(){
        for (Map.Entry<String, Action> eachOptionMenu : Menu.getMenu().entrySet()) {

            System.out.println(Menu.createMenuEntryString(eachOptionMenu.getKey(), eachOptionMenu.getValue()));
        }

        System.out.println();
    }

    public static void printWelcomeMessage() {
        System.out.println("\nWelcome to the Bangalore Public Library\n");
    }

    public static void informAboutTheBookNonEsxistence(String bookName){
        System.out.println("\nThe book " + bookName + " does not exist in the library\n");

    }

    public boolean signIn(String userName, String password){

        if(!this.usersManager.existUser(userName)){
            return false;
        }

        boolean authenticated = false;

        User objectiveUser = this.usersManager.getUser(userName);

        if(objectiveUser.checkPassword(password)){
            this.authenticatedUser = objectiveUser;
            authenticated = true;
        }

        return authenticated;
    }
}
