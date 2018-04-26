package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadFileTest {

    @Test
    public void readFile() {
        List<String> lines = ReadFile.getLines("readfile.txt");
        assertEquals(1, lines.size());
        assertEquals("test", lines.get(0));
    }
}
