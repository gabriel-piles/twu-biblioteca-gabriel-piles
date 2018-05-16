package com.twu.biblioteca;

import com.twu.biblioteca.actions.Action;

import java.util.*;

public class BibliotecaUI {

    private ItemsManager itemsManager;
    private Map<String, Action> menu;
    private UsersManager usersManager;
    private User authenticatedUser;

    public BibliotecaUI(ItemsManager itemsManager, UsersManager usersManager) {

        this.itemsManager = itemsManager;
        this.menu = Menu.getMenu();
        this.usersManager = usersManager;
    }

    public void initializeUI() {
        printWelcomeMessage();
        boolean continueProgram = true;

        while (continueProgram)
        {
            printMenu();
            String optionSelected = getUserInput("Option number:");

            if(!this.menu.containsKey(optionSelected)){
                System.out.println("Select a valid option\n");
                continue;
            }

            this.menu.get(optionSelected).execute(this.itemsManager, this.authenticatedUser);

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
        System.out.println("\n\nWelcome to the Bangalore Public Library\n");
    }

    public static void informAboutTheBookNonEsxistence(String bookName){
        System.out.println("\nThe book " + bookName + " does not exist in the library\n");

    }

    public boolean isUserValid(String userName, String password){

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

    public void signInProcess(){

        String userName = getUserInput("User name:");
        String password = getUserInput("Password:");

        if(isUserValid(userName,password )){
            initializeUI();
        }
        else {
            System.out.println("\nUser not valid");
        }
    }
}
