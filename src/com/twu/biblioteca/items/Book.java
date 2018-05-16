package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Item;

public class Book extends Item {

    private String author;

    public Book(String id, String name, String author, int year, boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    @Override
    public void printDetails() {
        System.out.println("\nName: " + this.name);
        System.out.println("Author: " + this.author);
        System.out.println("Year: " + this.year);

        printAvailability();
        System.out.println();
    }
}
