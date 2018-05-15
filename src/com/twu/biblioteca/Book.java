package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private int year;
    private boolean available;

    private User checkOutUser;


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable(){
        return available;
    }

    public void checkOut(User checkOutUser) {
        this.available = false;
        this.checkOutUser = checkOutUser;
    }

    public void returnBook(){
        this.available = true;
        this.checkOutUser = null;
    }

    public User getCheckOutUser(){
        return this.checkOutUser;
    }

    public Book(String name, String author, int year, boolean available) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public void printBookDetails() {
        System.out.println("\nName: " + name);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);

        if(available)
        {
            System.out.println("Available: yes");
        }
        else {
            System.out.println("Available: no");
        }
        System.out.println();
    }
}
