package com.example.alieninvasiongame.models;

import com.example.alieninvasiongame.settings.Settings;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Spaceship {
    private ImageView spaceshipImageView;
    private Group root;
    private double speed;
    private double newX;
    private double newY;
    private Pane gamePane;
    private List<Bullet> bullets;
    public Spaceship(Pane gamePane, Group root, Settings settings) {
        // Load spaceship image using getClass().getResource()
        Image spaceshipImage = new Image(getClass().getResource("/com/example/alieninvasiongame/spaceship-5.png").toExternalForm());

        this.root = root;
        this.speed = settings.getShipSpeed();

        // Create bullets List
        this.bullets = new ArrayList<>();

        // Create ImageView for the spaceship
        this.spaceshipImageView = new ImageView(spaceshipImage);

        // Set spaceship image size
        double newWidth = 50; // Adjust this value as needed
        this.spaceshipImageView.setFitWidth(newWidth);
        this.spaceshipImageView.setPreserveRatio(true); // Maintain aspect ratio

        // Calculate initial position at the bottom center
        double initialX = 0.0;
        double initialY = settings.getHeight();

        // Set initial position
        this.spaceshipImageView.setX(initialX);
        this.spaceshipImageView.setY(initialY);

        // Register keyboard event handler
        this.root.getScene().setOnKeyPressed(event -> handleKeyEvent(event));

        // Add spaceship to the game pane
        this.gamePane = gamePane;
        this.gamePane.getChildren().add(this.spaceshipImageView);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public Pane getGamePane() {
        return gamePane;
    }
    public void handleKeyEvent(KeyEvent event){
        this.newX = this.spaceshipImageView.getX();
        this.newY = this.spaceshipImageView.getY();

        if (event.getCode() == KeyCode.RIGHT){
            this.newX += this.speed; // Move right
        }
        else if (event.getCode() == KeyCode.LEFT){
            this.newX -= this.speed; // Move left
        }
        else if (event.getCode() == KeyCode.SPACE){
            // Calculate the initial position of the bullet (e.g., from the spaceship's position)
            double bulletX = getX() + (this.spaceshipImageView.getFitWidth() / 2);
            double bulletY = getY();

            // Create and fire a bullet
            Bullet bullet = new Bullet(this.gamePane, bulletX, bulletY);
            this.bullets.add(bullet);

            AnimationTimer gameLoop = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    Iterator<Bullet> iterator = getBullets().iterator();
                    while (iterator.hasNext()){
                        Bullet bullet1 = iterator.next();
                        bullet1.move();

                        // Check if the bullet is off-screen
                        if (bullet1.getY() < 0){
                            // Remove the bullet using the iterator's remove() method
                            iterator.remove();
                            getGamePane().getChildren().remove(bullet1.getBulletImageView());
                        }
                    }
                }
            };
            gameLoop.start();
        }



        // Ensure spaceship stays with bounds
        this.newX = Math.max(0, Math.min(this.newX, this.root.getScene().getWidth() - spaceshipImageView.getFitWidth()));
        this.newY = Math.max(0, Math.min(this.newY, this.root.getScene().getHeight() - spaceshipImageView.getFitHeight()));

        // Update spaceship's position
        this.spaceshipImageView.setX(this.newX);
        this.spaceshipImageView.setY(this.newY);

    }

    public double getX() {
        return newX;
    }

    public double getY() {
        return newY;
    }



    // Methods to control spaceship movement, shooting, and other behaviors can be added here
}