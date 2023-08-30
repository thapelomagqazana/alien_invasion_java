package com.example.alieninvasiongame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("Galactic Defender");

        // Set application icon
        Image icon = new Image("C:\\Users\\hifi\\OneDrive\\Desktop\\Java work\\AlienInvasionGame\\src\\main\\resources\\com\\example\\alieninvasiongame\\invasion.png");
        stage.getIcons().add(icon);

        // Create an empty black scene with a root node
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}