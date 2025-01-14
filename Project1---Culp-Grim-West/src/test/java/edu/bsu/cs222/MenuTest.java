package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @Test
    public void displayMenuTest(){
        Menu menu = new Menu();
        String result = menu.displayMenu();
        Assertions.assertEquals(result, "\nInput an article name to see revision history, or enter nothing to quit: ");
    }


}
