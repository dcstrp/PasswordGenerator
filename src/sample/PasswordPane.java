package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class PasswordPane extends BorderPane {

    private TextArea passwordTextArea;
    private ComboBox<Integer> passwordLengthsComboBox;
    private final Font FONT = Font.font("Verdana", 15);

    public PasswordPane() {
        initialize();
    }


    private void initialize() {

        VBox vboxPassword = createPasswordVBox();
        VBox vboxButtons = createButtonsVBox();
        VBox vboxPWLength = createPasswordLengthVBox();
        VBox vboxDisplay = new VBox(vboxPassword, vboxButtons, vboxPWLength);

        this.setCenter(vboxDisplay);
    }

    private VBox createPasswordVBox() {

        //create the controls
        Label passwordLbl = new Label("Password");
        passwordTextArea = new TextArea("");

        //configure their display and functionality
        passwordLbl.setFont(FONT);
        passwordTextArea.setEditable(false);
        passwordTextArea.setWrapText(true);
        passwordTextArea.setMaxSize(200, 20);
        passwordTextArea.setFont(FONT);

        //create and configure the vbox to be returned while adding the aforementioned controls

        VBox vbox = new VBox(passwordLbl, passwordTextArea);
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(25));
        vbox.setAlignment(Pos.CENTER);

        return vbox;
    }

    private VBox createPasswordLengthVBox() {


        Label lengthsLbl = new Label("Password length");
        lengthsLbl.setFont(FONT);

        //Use a collection in order to fill the combobox with several numbers representing password lengths
        ObservableList<Integer> listOfLengths = FXCollections.observableArrayList();
        for (int i = 12; i <= 256; i++) {
            listOfLengths.add(i);
        }

        //create the aforementioned combobox, binding the previously created collection to it
        passwordLengthsComboBox = new ComboBox<>(listOfLengths);

        //force the first combobox item to be selected, this avoids a potential NPE upon clicking the generate button
        passwordLengthsComboBox.getSelectionModel().selectFirst();

        //create and configure the vbox to be returned while adding the aforementioned controls
        VBox vbox = new VBox(lengthsLbl, passwordLengthsComboBox);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(15, 0, 0, 0));
        vbox.setAlignment(Pos.CENTER);

        return vbox;
    }

    private VBox createButtonsVBox() {

        //create the password generation button, add an event to generate the password
        Button generatePasswordButton = new Button("Generate");

        generatePasswordButton.setOnAction(e ->
        {
            int passwordLength = passwordLengthsComboBox.getSelectionModel().getSelectedItem();
            PasswordGenerator passwordGenerator = new PasswordGenerator(passwordLength);
            passwordTextArea.setText(passwordGenerator.createPassword());

        });

        //create the copy to clipboard button and create an animation that changes its text in order to provide visual feedback
        Button copyToClipboardButton = new Button("Copy to Clipboard");

        KeyValue kvText = new KeyValue(copyToClipboardButton.textProperty(), "Copied!");
        KeyFrame kvTextFrame = new KeyFrame(Duration.millis(1), kvText);

        KeyValue kvOriginalText = new KeyValue(copyToClipboardButton.textProperty(), "Copy to Clipboard");
        KeyFrame kvOriginalTextFrame = new KeyFrame(Duration.millis(2000), kvOriginalText);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(kvTextFrame, kvOriginalTextFrame);

        //Create an instance of Clipboard, this allows for the access to the System's clipboard.
        //This is done to copy the password at a click of a button, sparing the user from the usual copy/paste process
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        //Create an event to store the generated password on the clipboard. Upon storing, the previously created animation is played
        copyToClipboardButton.setOnAction(e ->
        {
            if (!passwordTextArea.getText().isEmpty()) {
                content.putString(passwordTextArea.getText());
                clipboard.setContent(content);
                timeline.play();
            }
        });

        //Straightforward clear button creation, there isn't much to say about this one
        Button clearPasswordButton = new Button("Clear");

        clearPasswordButton.setOnAction(e -> passwordTextArea.setText(""));

        //Create an array of buttons to format them all at once and thus, avoiding the need of writing several lines of repeated code
        Button[] buttons = {generatePasswordButton, clearPasswordButton, copyToClipboardButton};

        for (Button button : buttons) {
            button.setPrefSize(200, 20);
            button.setFont(FONT);
        }
        //create and configure the vbox to be returned while adding the aforementioned controls
        VBox vBox = new VBox(generatePasswordButton, copyToClipboardButton, clearPasswordButton);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(5, 0, 0, 0));
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

}
