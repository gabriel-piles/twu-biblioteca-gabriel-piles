package com.twu.biblioteca;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksManager {

    String file_name;
    List<Book> all_books;

    public BooksManager(String file_name) {
        this.file_name = file_name;
        all_books = initialize_list_all_books(file_name);
    }

    private List<Book> initialize_list_all_books(String file_name) {
        List<String> file_content = open_file(file_name);

        List<Book> books_in_file = new ArrayList<Book>();

        for (String each_line: file_content)
        {
            String[] fields = each_line.split("--");

            if (fields.length <= 3 || fields[0].equals("Name"))
            {
                continue;
            }

            boolean available = fields[3].equals("yes");

            Book new_book = new Book(fields[0], fields[1], Integer.parseInt(fields[2]), available);
            books_in_file.add(new_book);
        }

        return books_in_file;
    }

    private List<String> open_file(String file_name) {

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

    public List<Book> get_list_of_books() {
        List<String> books_names = new ArrayList<String>();

        for (Book each_book:all_books) {
            books_names.add(each_book.getName());
        }

        return all_books;
    }
}
