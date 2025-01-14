package edu.bsu.cs222;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class GUIHelper {
    public void ArticleNotFoundError(TextArea outputRevisions){
        try {
            RevisionBuilder builder = new RevisionBuilder();
            builder.buildRevisions();
            String redirect = builder.revisionList.getFirst().getRedirect();

            if (redirect != null) {
                outputRevisions.setText("Redirecting to " + redirect + "\n\n");
            }
            outputRevisions.appendText(builder.getAllRevisions().toString());
        }
        catch(Exception e) {
            outputRevisions.setText("\n-----------------------------------\nNo Article Found, try again later.\n-----------------------------------\n\n");
        }
    }
    public void networkCatch() {
        try {
            ConnectToWiki connect = new ConnectToWiki();
            connect.connectToWikipedia();
        }
        catch (Exception e) {
            Dialog<String> errorModalBox = new Dialog<>();
            errorModalBox.setHeight(111);
            errorModalBox.setContentText("Network Error, try again later.");
            errorModalBox.show();
            errorModalBox.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        }
    }

    public void noInputDialog(){
        if(ConnectToWiki.userInput.isEmpty()){
            Dialog<String> errorModalBox = new Dialog<>();
            errorModalBox.setHeight(111);
            errorModalBox.getDialogPane().setContent( new Label("No input found, input an article to get revisions."));
            errorModalBox.show();
            errorModalBox.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        }
    }
}
