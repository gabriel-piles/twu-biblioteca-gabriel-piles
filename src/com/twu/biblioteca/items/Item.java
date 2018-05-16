package com.twu.biblioteca.items;

import com.twu.biblioteca.User;

public abstract class Item {

    protected String id;
    protected String name;
    protected int year;
    protected boolean available;
    protected User checkOutUser;


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable(){
        return available;
    }

    public void checkOut(User checkOutUser) {
        this.available = false;
        this.checkOutUser = checkOutUser;
    }

    public void returnItem(){
        this.available = true;
        this.checkOutUser = null;
    }

    public User getCheckOutUser(){
        return this.checkOutUser;
    }

    public void printDetails() {
    }

    protected void printAvailability(){
        if(this.available)
        {
            System.out.println("Available: yes");
        }
        else {
            System.out.println("Available: no");
        }
    }
}
