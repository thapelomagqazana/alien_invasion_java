package com.example.alieninvasiongame.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Alien {
    private ImageView alienImageView;
    private double x;
    private double y;
    private double alienWidth;
    private double alienSpeed;

    public Alien(double alienWidth, double x, double y){
        // Load alien image using getClass().getResource()
        Image alienImage = new Image(getClass().getResource("/com/example/alieninvasiongame/alien.png").toExternalForm());

        // Calculate the scale factor to maintain aspect ratio
        this.alienWidth = alienWidth;
        double scaleFactor = this.alienWidth / alienImage.getWidth();

        // Create ImageView for the alien with the scaled size
        this.alienImageView = new ImageView(alienImage);
        this.alienImageView.setFitWidth(alienImage.getWidth() * scaleFactor);
        this.alienImageView.setPreserveRatio(true);

        // Initial position of the alien
        this.x = x;
        this.y = y;
        this.alienImageView.setX(this.x);
        this.alienImageView.setY(this.y);

        this.alienSpeed = 0.03;
    }

    public void move(){
        this.y += alienSpeed;
        this.alienImageView.setY(this.y);

    }
    public ImageView getAlienImageView() {
        return alienImageView;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAlienWidth() {
        return alienWidth;
    }

}
