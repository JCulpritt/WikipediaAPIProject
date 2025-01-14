package edu.bsu.cs222;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUI extends Application {

    public static void main(String[] args) { launch(args); }

    private final Button getArticleButton = new Button("Get Article");

    private final TextField inputArticleName = new TextField();
    private final TextArea outputRevisions = new TextArea();

    @Override
    public void start(Stage stage) {
        outputRevisions.setEditable(false);
        configure(stage);
        configureArticleButton();
    }
    private void configure(Stage stage) {
        stage.setTitle("Article Getter");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }

    private Pane createRoot(){
        VBox root = new VBox();
        root.getChildren().addAll(
                new Label("Article Input:"),
                inputArticleName,
                getArticleButton,
                new Label("Revisions:"),
                outputRevisions);
        return root;
    }

    private void configureArticleButton(){getArticleButton.setOnAction(event -> inputArticleNameToRevisions());}

    private void inputArticleNameToRevisions() {
        outputRevisions.clear();
        GUIHelper helper = new GUIHelper();
        if (ConnectToWiki.userInput.isEmpty()) {
            outputRevisions.setText("Quitting...");
        }
        ConnectToWiki.userInput = inputArticleName.getText();
        helper.networkCatch();
        helper.ArticleNotFoundError(outputRevisions);
        helper.noInputDialog();
    }
}
