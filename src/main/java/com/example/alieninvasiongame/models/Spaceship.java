package com.example.alieninvasiongame.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Spaceship {
    private ImageView spaceshipImageView;

    public Spaceship(Pane gamePane, double sceneWidth, double sceneHeight) {
        // Load spaceship image using getClass().getResource()
        Image spaceshipImage = new Image(getClass().getResource("/com/example/alieninvasiongame/spaceship-5.png").toExternalForm());

        // Create ImageView for the spaceship
        spaceshipImageView = new ImageView(spaceshipImage);

        // Set spaceship image size
        double newWidth = 50; // Adjust this value as needed
        spaceshipImageView.setFitWidth(newWidth);
        spaceshipImageView.setPreserveRatio(true); // Maintain aspect ratio

        // Calculate initial position at the bottom center
        double initialX = (sceneWidth - newWidth) / 2;
        double initialY = sceneHeight - spaceshipImageView.getFitHeight();

        // Set initial position
        spaceshipImageView.setX(0);
        spaceshipImageView.setY(sceneHeight);

        // Add spaceship to the game pane
        gamePane.getChildren().add(spaceshipImageView);
    }

    // Methods to control spaceship movement, shooting, and other behaviors can be added here
}