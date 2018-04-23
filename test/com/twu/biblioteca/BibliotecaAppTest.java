package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BibliotecaAppTest {

    @Test
    public void initialize_biblioteca_app() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertNotEquals(bibliotecaApp, null);
    }
}
