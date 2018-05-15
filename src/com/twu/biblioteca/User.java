package com.twu.biblioteca;

public class User {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private boolean admin;

    public String getName() {
        return name;
    }

    public User(String id, String name, String email, String phone, String password, boolean admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.admin = admin;
    }

    public void printUserDetails() {
        System.out.println("\nId: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("E-mail: " + this.email);
        System.out.println("Phone number: " + this.phone);

        if(this.admin)
        {
            System.out.println("Admin: yes");
        }
        else {
            System.out.println("Admin: no");
        }
        System.out.println();
    }

    public boolean checkPassword(String possiblePassword){
        return possiblePassword == this.password;
    }
}
