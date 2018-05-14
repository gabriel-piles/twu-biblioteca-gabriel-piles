package com.twu.biblioteca;


import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaUITest {

    @Test
    public void printWelcomeMessage() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI.printWelcomeMessage();
        assertEquals("Welcome to the Bangalore Public Library", outputStream.toString().trim());
    }

    @Test
    public void printAvailableBooks() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printAvailableBooks();

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
    }


    @Test
    public void printResultCheckOutBookCorrect() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printResultCheckOutBook("first book");

        assertEquals("The book first book was successfully checked out", outputStream.toString().trim());
    }

    @Test
    public void printResultCheckOutBookFail() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printResultCheckOutBook("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());
    }


    @Test
    public void printResultCheckOutBookAlreadyCheckedOut() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printResultCheckOutBook("second book");

        assertEquals("The book second book is already checked out", outputStream.toString().trim());
        System.out.println("Something");
    }

    @Test
    public void printResultReturnBookCorrect() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printResultReturnBook("second book");

        assertEquals("The book second book was successfully returned", outputStream.toString().trim());
    }

    @Test
    public void printResultReturnBookInLibrary() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printResultReturnBook("first book");

        assertEquals("The book first book is not checked out", outputStream.toString().trim());
    }

    @Test
    public void printResultReturnBookFail() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printResultReturnBook("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());
    }

    @Test
    public void printBookDetailsFirstBook() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printBookDetails("first book");

        assertThat(outputStream.toString(), CoreMatchers.containsString("first book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("2009"));
        assertThat(outputStream.toString().trim(), CoreMatchers.containsString("yes"));
    }

    @Test
    public void printBookDetailsSecondBook() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printBookDetails("second book");

        assertThat(outputStream.toString(), CoreMatchers.containsString("second book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("gabriel piles"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("2007"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("no"));

    }

    @Test
    public void printBookDetailsNonExistentBook() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI bibliotecaUI = initializeBibliotecaUI();

        bibliotecaUI.printBookDetails("third book");

        assertEquals("The book third book does not exist in the library", outputStream.toString().trim());

    }

    private OutputStream prepareRedirectOutputForTests(){

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
        return outputStream;
    }

    private BibliotecaUI initializeBibliotecaUI(){
        BooksManager booksManager = new BooksManager("test.txt");
        BibliotecaUI bibliotecaUI = new BibliotecaUI(booksManager);

        return bibliotecaUI;
    }
}
