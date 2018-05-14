package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BibliotecaUITest {

    @Test
    public void printWelcomeMessage() {
        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI.printWelcomeMessage();
        assertEquals("Welcome to the Bangalore Public Library", outputStream.toString().trim());
    }

    @Test
    public void printDictionary() {

        Map<String, String> genericDictionary = new HashMap();

        genericDictionary.put("1", "a");
        genericDictionary.put("2", "b");

        OutputStream outputStream = prepareRedirectOutputForTests();
        BibliotecaUI.printDictionary(genericDictionary);
        assertEquals("1 a\n2 b", outputStream.toString().trim());
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
