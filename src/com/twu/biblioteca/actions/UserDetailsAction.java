package com.twu.biblioteca.actions;

import com.twu.biblioteca.BibliotecaUI;
import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

public class UserDetailsAction implements Action {

    @Override
    public String getName() {
        return "User Details";
    }

    @Override
    public void execute(ItemsManager itemsManager, User user) {
        user.printUserDetails();
    }
}
