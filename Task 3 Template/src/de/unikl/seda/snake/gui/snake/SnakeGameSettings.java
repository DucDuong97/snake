package de.unikl.seda.snake.gui.snake;

import static de.unikl.seda.snake.gui.snake.SnakeGameSettings.GameLevel.*;

public class SnakeGameSettings {

    private String playerName = "player";
    private GameLevel gameLevel = NO_BORDER;
    private int gameSpeed = 200;
    private int squareSize = 100;
    private int height = 600;
    private int width = 800;

    public SnakeGameSettings() {}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    enum GameLevel {
        NO_BORDER, BOX, VERTICAL_LINES;
    }
}
