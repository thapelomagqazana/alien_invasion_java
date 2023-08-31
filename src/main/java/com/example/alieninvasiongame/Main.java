package com.example.alieninvasiongame;

import com.example.alieninvasiongame.models.Spaceship;
import com.example.alieninvasiongame.settings.Settings;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage){
        stage.setTitle("Galactic Defender");

        // Set application icon
        Image icon = new Image("C:\\Users\\hifi\\OneDrive\\Desktop\\Java work\\AlienInvasionGame\\src\\main\\resources\\com\\example\\alieninvasiongame\\invasion.png");
        stage.getIcons().add(icon);

        // Initialized the settings
        Settings settings = new Settings();

        // Create an empty black scene with a root node
        Group root = new Group();

        Pane gamePane = new Pane();
        root.getChildren().add(gamePane);

        Scene scene = new Scene(root, settings.getHeight(), settings.getWidth());
        scene.setFill((Paint) settings.getColors().get("black"));

        stage.setScene(scene);
        stage.show();


        // Create and display the spaceship after the scene is shown
        Spaceship spaceship = new Spaceship(gamePane, settings.getWidth(), settings.getHeight());

    }

    public static void main(String[] args) {
        launch();
    }
}