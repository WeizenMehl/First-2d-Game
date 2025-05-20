package org.example.first2dgame;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

import static com.almasb.fxgl.app.GameApplication.launch;

public class First2dGame extends GameApplication {
    private final GameFactory gameFactory = new GameFactory();
    private Entity player;

    private static int screenWidth;
    private static int screenHeight;

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int) screenSize.getWidth();
        screenHeight = (int) screenSize.getHeight();
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setHeight(screenHeight);
        settings.setWidth(screenWidth);
        settings.setFullScreenAllowed(true);
        settings.setFullScreenFromStart(true);
        settings.setTitle("Oracle Java Magazine - FXGL");
    }
}