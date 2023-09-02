package com.example.alieninvasiongame;

import com.example.alieninvasiongame.models.Bullet;
import com.example.alieninvasiongame.models.Spaceship;
import com.example.alieninvasiongame.models.alienmanagement.AlienManagement;
import com.example.alieninvasiongame.settings.Settings;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

//        // Enable fullscreen mode
//        stage.setFullScreen(true);
//        stage.setFullScreenExitHint("Press ESC to exit fullscreen");
//        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("ESCAPE"));

        stage.setScene(scene);
        stage.show();


        // Create and display the spaceship after the scene is shown
        Spaceship spaceship = new Spaceship(gamePane, root,  settings);
        // Create and display the aliens
        AlienManagement aliens = new AlienManagement(gamePane, settings);

        // Set up your game loop or timer to call moveAllAliens periodically
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                aliens.moveAllAliens();
            }
        }, 0, 16);

    }

    public static void main(String[] args) {
        launch();
    }
}