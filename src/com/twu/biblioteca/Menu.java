package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public static List<Option> getMenu(){
        List<Option> menu_options = new ArrayList<Option>();

        menu_options.add(new Option(1, "List Books"));
        menu_options.add(new Option(2, "Book Details"));
        menu_options.add(new Option(3, "Checkout Book"));
        menu_options.add(new Option(4, "Return Book"));
        menu_options.add(new Option(5, "Quit"));

        return menu_options;
    }

}
