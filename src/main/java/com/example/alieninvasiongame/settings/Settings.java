package com.example.alieninvasiongame.settings;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private Map colors = new HashMap<>();

    public Settings(){
        this.colors.put("white", Color.WHITE);
        this.colors.put("black", Color.BLACK);
    }
    public Map getColors() {
        return this.colors;
    }

    public int getHeight() {
        return this.HEIGHT;
    }

    public int getWidth() {
        return this.WIDTH;
    }


}
