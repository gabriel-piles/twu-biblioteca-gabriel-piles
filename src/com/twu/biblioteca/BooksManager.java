package com.twu.biblioteca;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BooksManager {

    String fileName;
    Map<String, Book> allBooks;

    public BooksManager(String fileName) {
        this.fileName = fileName;
        allBooks = initializeAllBooksList(fileName);
    }

    private Map<String, Book> initializeAllBooksList(String file_name) {
        List<String> file_content = readFileListBooks(file_name);

        Map<String, Book> booksInFile = new HashMap();

        for (String each_line: file_content)
        {
            String[] fields = each_line.split("--");

            if (fields.length <= 3 || fields[0].equals("Name") || booksInFile.containsKey(fields[0]))
            {
                continue;
            }

            boolean available = fields[3].equals("yes");

            Book newBook = new Book(fields[0], fields[1], Integer.parseInt(fields[2]), available);
            booksInFile.put(fields[0], newBook);
        }

        return booksInFile;
    }

    private List<String> readFileListBooks(String file_name) {

        List<String> lines = new ArrayList<String>();

        try {
            Scanner file_content = new Scanner(new File("./test/" + file_name));
            while(file_content.hasNextLine())
            {
                lines.add(file_content.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public Map<String, Book> getAllBooks() {
        return allBooks;
    }

    public List<Book> getBooksSatisfyCondition(boolean hasToBeAvailable) {
        List<Book> booksSatisfyCondition = new ArrayList<Book>();

        for (Map.Entry<String, Book> eachBook : this.allBooks.entrySet()) {

            if (eachBook.getValue().isAvailable() == hasToBeAvailable)
            {
                booksSatisfyCondition.add(eachBook.getValue());
            }
        }

        return booksSatisfyCondition;
    }

    public boolean setAvailibityBook(String bookName, boolean availability) {

        if(!this.allBooks.containsKey(bookName))
        {
            return false;
        }

        if (this.allBooks.get(bookName).isAvailable() == availability)
        {
            return false;
        }

        this.allBooks.get(bookName).setAvailability(availability);
        return true;
    }
}
