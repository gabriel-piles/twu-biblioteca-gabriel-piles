package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UsersManagerTest {

    @Test
    public void initializeUsers() {
        UsersManager usersManager = new UsersManager("users.txt");
        Map<String, User> users = usersManager.getAllUsers();
        assertEquals(2, users.size());
    }
}
