package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    public static Map<Integer, String> getMenu(){
        Map<Integer, String> menu_options = new HashMap();

        menu_options.put(1, "List Books");
        menu_options.put(2, "Book Details");
        menu_options.put(3, "Checkout Book");
        menu_options.put(4, "Return Book");
        menu_options.put(5, "Quit");

        return menu_options;
    }

}
