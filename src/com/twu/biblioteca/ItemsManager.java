package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;

import java.util.*;

public class ItemsManager {

    Map<String, Item> allItems;

    public Map<String, Item> getAllItems() {
        return this.allItems;
    }

    public ItemsManager(String bookFileName, String movieFileName) {
        this.allItems = new HashMap();
        initializeListFromFile(this.allItems, bookFileName, "book");
        initializeListFromFile(this.allItems, movieFileName, "movie");
    }

    private void initializeListFromFile(Map<String, Item> itemList, String fileName, String itemClass) {
        List<String> file_content = ReadFile.getLines(fileName);
        
        boolean firstLine = true;

        for (String each_line : file_content) {
            
            if (firstLine) {
                firstLine = false;
                continue;
            }
            
            String[] fields = each_line.split("--");

            if (itemList.containsKey(fields[0])) {
                continue;
            }
            
            Item newItem = null;
            
            if (itemClass.equals("book"))
            {
                newItem = createNewBook(fields);
            }

            if (itemClass.equals("movie"))
            {
                newItem = createNewBook(fields);
            }
            
            itemList.put(fields[0], newItem);
        }
    }

    private Item createNewBook(String[] fields) {
        boolean available = fields[4].equals("yes");
        return new Book(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), available);
    }

    private Item createNewMovie(String[] fields) {
        boolean available = fields[5].equals("yes");
        return new Movie(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]),available);
    }

    public List<Item> getBooksThatSatisfyCondition(boolean hasToBeAvailable) {
        List<Item> booksSatisfyCondition = new ArrayList<>();

        for (Map.Entry<String, Item> eachItem : this.allItems.entrySet()) {

            if (eachItem.getValue().isAvailable() == hasToBeAvailable) {
                booksSatisfyCondition.add(eachItem.getValue());
            }
        }

        return booksSatisfyCondition;
    }

    public Boolean existItem(String bookName) {
        if (!this.allItems.containsKey(bookName)) {
            return false;
        }

        return true;

    }

    public Item getItem(String bookName) {

        if (!existItem(bookName)) {
            return null;
        }

        return this.allItems.get(bookName);
    }

    public List<Item> listAvailableBooks() {
        return getBooksThatSatisfyCondition(true);
    }

    public List<Item> listCheckOutBooks() {
        return getBooksThatSatisfyCondition(false);
    }

    public boolean checkOutItem(String bookName, User checkOutUser) {

        if (!existItem(bookName)) {
            return false;
        }

        if (!this.allItems.get(bookName).isAvailable()) {
            return false;
        }

        this.allItems.get(bookName).checkOut(checkOutUser);
        return true;
    }

    public boolean returnItem(String itemName) {
        if (!existItem(itemName)) {
            return false;
        }

        if (this.allItems.get(itemName).isAvailable()) {
            return false;
        }

        this.allItems.get(itemName).returnItem();
        return true;
    }
}
