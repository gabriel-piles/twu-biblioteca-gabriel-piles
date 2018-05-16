package com.twu.biblioteca.actions;


import com.twu.biblioteca.ItemsManager;
import com.twu.biblioteca.ItemsManagerTest;
import com.twu.biblioteca.TestHelpers;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.OutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class QuitTest {

    @Test
    public void getName() {
        QuitAction quit = new QuitAction();
        assertEquals("Quit", quit.getName());
    }

    @Test
    public void execute() {
        OutputStream outputStream = TestHelpers.prepareRedirectOutputForTests();

        QuitAction quit = new QuitAction();
        quit.execute(ItemsManagerTest.initializeItemManagerForTesting(), TestHelpers.getUserTest());
        assertThat(outputStream.toString(), CoreMatchers.containsString("Good Bye"));

    }
}
