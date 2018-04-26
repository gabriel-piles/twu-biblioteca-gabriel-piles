package com.twu.biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public static List<String> getLines(String file_name) {

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
}
