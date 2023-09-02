package com.example.alieninvasiongame.models.alienmanagement;

import com.example.alieninvasiongame.models.Alien;
import com.example.alieninvasiongame.settings.Settings;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class AlienManagement {
    private List<Alien> aliens;
    private Pane gamePane;
    private Settings settings;
    public AlienManagement(Pane gamePane, Settings settings){
        this.gamePane = gamePane;
        this.settings = settings;
        generateAlienList();
        viewAliens();
    }

    private void generateAlienList(){
        this.aliens = new ArrayList<>();
        int numberOfAliens = Math.floorDiv(this.settings.getWidth(), (int) this.settings.getAlienWidth());

        // Calculate the desired width for each alien
        double desiredWidth = this.settings.getWidth() / numberOfAliens;

        int x = 0;
        int spacing = 80;
        for (int i = 0; i < numberOfAliens; i++){
            Alien alien = new Alien(desiredWidth, x, 0);
            this.aliens.add(alien);
            x += this.settings.getAlienWidth() + spacing;
        }
    }
    private void viewAliens(){
        for (Alien alien : this.aliens){
            ImageView alienIV = alien.getAlienImageView();
            alienIV.setX(alien.getX());
            alienIV.setY(alien.getY());
            this.gamePane.getChildren().add(alienIV);
        }
    }
}
