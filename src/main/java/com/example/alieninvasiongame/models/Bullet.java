package com.example.alieninvasiongame.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bullet {
    private ImageView bulletImageView;
    private double speed;
    private double x;
    private double y;

    public Bullet(Pane gamePane, double x, double y){
        this.x = x;
        this.y = y;
        // Load bullet image using getClass().getResource()
        Image bulletImage = new Image(getClass().getResource("/com/example/alieninvasiongame/bullet.png").toExternalForm());
        bulletImageView = new ImageView(bulletImage);
        bulletImageView.setX(this.x);
        bulletImageView.setY(this.y);

        // Set spaceship image size
        double newWidth = 8; // Adjust this value as needed
        bulletImageView.setFitWidth(newWidth);
        bulletImageView.setPreserveRatio(true); // Maintain aspect ratio

        gamePane.getChildren().add(bulletImageView);

        // Set the bullet's speed
        speed = 4.0;
    }

    public void move(){
        // Move the bullet upwards
        this.y -= speed;
        bulletImageView.setY(this.y);
    }

    public ImageView getBulletImageView(){
        return bulletImageView;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
