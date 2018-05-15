package com.twu.biblioteca;


import com.twu.biblioteca.actions.ReturnBookAction;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BibliotecaUITest {

    @Test
    public void printWelcomeMessage() {
        OutputStream outputStream =TestHelpers.prepareRedirectOutputForTests();
        BibliotecaUI.printWelcomeMessage();
        assertEquals("Welcome to the Bangalore Public Library", outputStream.toString().trim());
    }

    @Test
    public void userInput() {
        OutputStream outputStream =TestHelpers.prepareRedirectOutputForTests();
        TestHelpers.userInput("input");
        String userStringInput = BibliotecaUI.getUserInput("test");


        assertEquals("test", outputStream.toString().trim());
        assertEquals("input", userStringInput);
    }

    @Test
    public void informBookNonExistence() {
        OutputStream outputStream =TestHelpers.prepareRedirectOutputForTests();
        BibliotecaUI.informAboutTheBookNonEsxistence("test");
        assertEquals("The book test does not exist in the library", outputStream.toString().trim());
    }

    @Test
    public void printMenu() {
        OutputStream outputStream =TestHelpers.prepareRedirectOutputForTests();
        BibliotecaUI.printMenu();

        assertThat(outputStream.toString(), CoreMatchers.containsString("1 List Books"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("2 Book Details"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("3 Checkout Book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("4 Return Book"));
        assertThat(outputStream.toString(), CoreMatchers.containsString("5 Quit"));
    }

    @Test
    public void userInputReturnBookCorrect() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();
        BooksManager booksManager = new BooksManager("test.txt");
        UsersManager userManager = new UsersManager("users.txt");

        BibliotecaUI bibliotecaUI = new BibliotecaUI(booksManager, userManager);

        TestHelpers.userInput("5");
        bibliotecaUI.initializeUI();

        assertThat(outputStream.toString(), CoreMatchers.containsString("1 List Books"));
    }

    @Test
    public void signIn() {
        BooksManager booksManager = new BooksManager("test.txt");
        UsersManager userManager = new UsersManager("users.txt");

        BibliotecaUI bibliotecaUI = new BibliotecaUI(booksManager, userManager);

        assertTrue(!bibliotecaUI.signIn("aa", "0"));
        assertTrue(!bibliotecaUI.signIn("000-001", "0"));
        assertTrue(bibliotecaUI.signIn("000-001", "1"));
    }
}
