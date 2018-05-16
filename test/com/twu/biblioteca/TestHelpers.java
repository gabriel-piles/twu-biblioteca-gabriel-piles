package com.twu.biblioteca;


import java.io.*;


public class TestHelpers {

    public static OutputStream prepareRedirectOutputForTests(){

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        System.setOut(ps);
        return outputStream;
    }

    public static void userInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    public static User getUserTest(){
        return new User("000-001","Gabriel Piles","me@me.com","651...","v",false);
    }
}
