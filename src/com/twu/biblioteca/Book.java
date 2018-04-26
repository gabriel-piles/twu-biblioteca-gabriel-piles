package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private int year;
    private boolean available;


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

    public void setAvailability(boolean available) {
        this.available = available;
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
