package com.twu.biblioteca;

import com.twu.biblioteca.actions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    public static Map<String, Action> getMenu(){

        Map<String, Action> actionsMap;

        actionsMap = new HashMap();

        actionsMap.put("1", new ListAvailableBooksAction());
        actionsMap.put("2", new BookDetailsAction());
        actionsMap.put("3", new CheckOutBookAction());
        actionsMap.put("4", new ReturnBookAction());
        actionsMap.put("5", new QuitAction());

        return actionsMap;
    }

    public static String createMenuEntryString(String actionId, Action someAction)
    {
        return actionId + " " + someAction.getName();
    }
}
