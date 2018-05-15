package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersManager {

    String fileName;
    Map<String, User> allUsers;

    public Map<String, User> getAllUsers() {
        return this.allUsers;
    }

    public UsersManager(String fileName) {
        this.fileName = fileName;
        this.allUsers = initializeUsers(fileName);
    }

    private Map<String,User> initializeUsers(String fileName) {

        List<String> file_content = ReadFile.getLines(fileName);

        Map<String, User> usersList = new HashMap();

        for (String each_line: file_content)
        {
            //222-222--Gabo TW--gabo@me.com--96...--b--yes
            String[] fields = each_line.split("--");

            if (fields.length <= 5 || fields[0].equals("User Id") || usersList.containsKey(fields[0]))
            {
                continue;
            }

            boolean admin = fields[3].equals("yes");

            User newUser = new User(fields[0], fields[1], fields[2], fields[3], fields[4], admin);
            usersList.put(fields[0], newUser);
        }

        return usersList;
    }
}
