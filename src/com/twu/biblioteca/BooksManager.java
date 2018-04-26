package com.twu.biblioteca;
import java.util.*;

public class BooksManager {

    String fileName;
    Map<String, Book> allBooks;

    public Map<String, Book> getAllBooks() {
        return allBooks;
    }

    public BooksManager(String fileName) {
        this.fileName = fileName;
        allBooks = initializeAllBooksList(fileName);
    }

    private Map<String, Book> initializeAllBooksList(String file_name) {
        List<String> file_content = ReadFile.getLines(file_name);

        Map<String, Book> booksList = new HashMap();

        for (String each_line: file_content)
        {
            String[] fields = each_line.split("--");

            if (fields.length <= 3 || fields[0].equals("Name") || booksList.containsKey(fields[0]))
            {
                continue;
            }

            boolean available = fields[3].equals("yes");

            Book newBook = new Book(fields[0], fields[1], Integer.parseInt(fields[2]), available);
            booksList.put(fields[0], newBook);
        }

        return booksList;
    }

    public List<Book> getBooksThatSatisfyCondition(boolean hasToBeAvailable) {
        List<Book> booksSatisfyCondition = new ArrayList<Book>();

        for (Map.Entry<String, Book> eachBook : this.allBooks.entrySet()) {

            if (eachBook.getValue().isAvailable() == hasToBeAvailable)
            {
                booksSatisfyCondition.add(eachBook.getValue());
            }
        }

        return booksSatisfyCondition;
    }

    public boolean setAvailabilityToBook(String bookName, boolean availability) {

        if(!this.allBooks.containsKey(bookName))
        {
            return false;
        }

        return this.allBooks.get(bookName).setAvailability(availability);
    }

    public List<Book> listAvailableBooks() {
        return getBooksThatSatisfyCondition(true);
    }

    public List<Book> listCheckOutBooks() {
        return getBooksThatSatisfyCondition(false);
    }

    public boolean checkOutBook(String bookName) {

        return setAvailabilityToBook(bookName, false);
    }

    public boolean returnBook(String bookName) {
        return setAvailabilityToBook(bookName, true);
    }
}
