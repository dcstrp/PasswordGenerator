package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Password Generator");
        primaryStage.setScene(new Scene(new PasswordPane(), 400, 330));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/image/testico.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
