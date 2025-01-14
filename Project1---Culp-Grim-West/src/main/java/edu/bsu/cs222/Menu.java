package edu.bsu.cs222;

import java.util.Scanner;

public class Menu {
    private static final Scanner SCANNER = new Scanner(System.in);

    protected String displayMenu(){
        return "\nInput an article name to see revision history, or enter nothing to quit: ";
    }

    protected void userInput(){
        ConnectToWiki.userInput = SCANNER.nextLine();
    }

}
