package com.twu.biblioteca.items;

import com.twu.biblioteca.User;
import com.twu.biblioteca.items.Item;

public class Movie extends Item {

    private String director;
    private int rating;

    public Movie(String id, String name, String director, int year, int rating, boolean available) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.available = available;
    }
    
    @Override
    public void printDetails(User signInUser) {
        System.out.println("\nName: " + this.name);
        System.out.println("Director: " + this.director);
        System.out.println("Year: " + this.year);
        System.out.println("Rating: " + this.rating);

        printAvailability();
        printUser(signInUser);
        System.out.println();
    }
}
