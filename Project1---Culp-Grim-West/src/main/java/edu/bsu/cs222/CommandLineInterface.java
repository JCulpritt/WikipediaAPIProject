package edu.bsu.cs222;

public class CommandLineInterface {
    public static void main(String[] args) {

        while(true) {
            CommandLineInterface main = new CommandLineInterface();
            main.networkCatch();
            main.runMenu();
            if(ConnectToWiki.userInput.isEmpty()) {
                System.out.print("Quitting...");
                break;
            }
            main.printRevisions();
        }

    }

    private void runMenu() {
        Menu menu = new Menu();
        System.out.println(menu.displayMenu());
        menu.userInput();
    }
    public void networkCatch() {
        try {
            ConnectToWiki connect = new ConnectToWiki();
            connect.connectToWikipedia();
        }
        catch (Exception e) {
            System.out.println("\n\n-----------------------------------\nNetwork Error, try again later.\n-----------------------------------\n\n");
            System.exit(0);
        }
    }

    private void printRevisions() {
        //Try and catch block used to catch when no article is found
        try {
            RevisionBuilder builder = new RevisionBuilder();
            builder.buildRevisions();
            String redirect = builder.revisionList.getFirst().getRedirect();

            if (redirect != null) {
                System.out.println("Redirecting to " + redirect);
            }
            System.out.print(builder.getAllRevisions());
        }
        catch(Exception e) {
            System.out.println("\n\n-----------------------------------\nNo Article Found, try again later.\n-----------------------------------\n\n");
            System.exit(0);
        }
    }
}
