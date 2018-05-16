package com.twu.biblioteca.actions;

import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;

public interface Action {
    public String getName();
    public void execute(ItemsManager itemsManager, User user);
}
