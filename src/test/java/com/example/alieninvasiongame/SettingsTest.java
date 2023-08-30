package com.example.alieninvasiongame;

import com.example.alieninvasiongame.settings.Settings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SettingsTest {
    @Test
    void testSettingsWindowSizeWithBackgroundColor(){
        Settings settings = new Settings();

        assertEquals(800, settings.getHeight());
        assertEquals(600, settings.getWidth());
        assertTrue(settings.getColors().containsKey("black"));
        assertTrue(settings.getColors().containsKey("white"));
    }
}
