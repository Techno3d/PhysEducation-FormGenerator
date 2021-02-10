package PhysEdFormGen.src;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    private Button button;
    private Button format;
    private String[] formattedLetterDef;
    private boolean isLetterDefDefined;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PeForm Filler");

        isLetterDefDefined = false;

        //Text Area for letter definitions
        TextArea textArea = new TextArea();
        textArea.setMinSize(300, 350);

        //Text Area for Words
        TextArea wordsTextArea = new TextArea();
        textArea.setMinSize(300, 80);

        Label label = new Label("Enter in the leter definitions with an enter after each leter definition");

        Label wordLabel = new Label("Enter in the words you want formated with an enter after each word.");

        TextArea formattedWords = new TextArea();
        textArea.setMinHeight(20);
        formattedWords.setText(" ");

        //Button
        button = new Button("Okay");
        button.setOnAction(action -> {
            String[] unformattedLetterDef = textArea.getText().toLowerCase().split("\n");
            formattedLetterDef = new String[26];

            //Stops any length more than 26 from getting thorugh
            for(int i = 0; i<26; i++) {
                try {
                    formattedLetterDef[i] = unformattedLetterDef[i];
                } catch (Exception e) {
                    formattedLetterDef[i] = " ";
                }
            }
            for(int i = 0; i<formattedLetterDef.length; i++) {
                formattedLetterDef[i] = formattedLetterDef[i].trim();
            }
            isLetterDefDefined = true;
        });

        format = new Button("Format");
        format.setOnAction(action -> {
            String[] words = wordsTextArea.getText().toLowerCase().split("\n");
            for(int i = 0; i<words.length; i++) {
                words[i] = words[i].trim();
            }
            if(isLetterDefDefined) {
                formattedWords.setText(Formatter.wordFormatter(formattedLetterDef, words));
            } else {
                formattedWords.setText("No Letter definitions were set, please enter some before getting formated words.");
            }
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(label, textArea, button, wordLabel, wordsTextArea, format, formattedWords);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 550, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
