package com.twu.biblioteca;

import com.twu.biblioteca.actions.*;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    public static Map<String, Action> getMenu(){

        Map<String, Action> actionsMap;

        actionsMap = new HashMap();

        actionsMap.put("1", new ListAvailableBooksAction());
        actionsMap.put("2", new ListAvailableMoviesAction());
        actionsMap.put("3", new ListCheckoutItemsAction());
        actionsMap.put("4", new ItemDetailsAction());
        actionsMap.put("5", new CheckOutItemAction());
        actionsMap.put("6", new ReturnItemAction());
        actionsMap.put("7", new UserDetailsAction());
        actionsMap.put("8", new QuitAction());

        return actionsMap;
    }

    public static String createMenuEntryString(String actionId, Action someAction)
    {
        return actionId + " " + someAction.getName();
    }
}
