package com.twu.biblioteca;

import com.twu.biblioteca.actions.Action;
import com.twu.biblioteca.actions.CheckOutBookAction;
import com.twu.biblioteca.actions.ListAvailableBooksAction;
import com.twu.biblioteca.actions.QuitAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    public static Map<Integer, Action> getMenu(){

        Map<Integer, Action> actionsMap;

        actionsMap = new HashMap();

        actionsMap.put(1, new ListAvailableBooksAction());
        actionsMap.put(2, new ListAvailableBooksAction());
        actionsMap.put(3, new ListAvailableBooksAction());
        actionsMap.put(4, new ListAvailableBooksAction());
        actionsMap.put(5, new QuitAction());

        return actionsMap;
    }

    public static String createMenuEntryString(Integer actionId, Action someAction)
    {
        return actionId + ' ' + someAction.getName();
    }
}
