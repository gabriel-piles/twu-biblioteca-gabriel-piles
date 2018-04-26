package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void stringIsNotANumber() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertEquals(false, bibliotecaApp.stringIsAInteger(""));
        assertEquals(false, bibliotecaApp.stringIsAInteger("aaa"));

    }

    @Test
    public void stringIsANumber() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        assertEquals(true, bibliotecaApp.stringIsAInteger("1"));
        assertEquals(true, bibliotecaApp.stringIsAInteger("10"));

    }

}
