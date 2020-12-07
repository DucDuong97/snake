package de.unikl.seda.snake.gui.snake;

import static de.unikl.seda.snake.gui.snake.SnakeGameSettings.GameLevel.*;

public class SnakeGameSettings {

    private String playerName;
    private GameLevel gameLevel;
    private int gameSpeed;
    private int squareSize;
    private int height;
    private int width;

    private int xBound;
    private int yBound;

    public enum GameLevel {
        NO_BORDER, BOX, VERTICAL_LINES;
    }

    public SnakeGameSettings() {
        playerName = "player";
        gameLevel = NO_BORDER;
        gameSpeed = 200;
        squareSize = 50;
        height = 600;
        width = 800;

        this.xBound = this.width / this.squareSize;
        this.yBound = this.height / this.squareSize;
    }


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
        this.width = this.squareSize *(this.width / this.squareSize);
        this.height = this.squareSize *(this.height / this.squareSize);
        this.xBound = this.width / this.squareSize;
        this.yBound = this.height / this.squareSize;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.yBound = this.height / this.squareSize;
        this.height = this.squareSize * this.yBound;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.xBound = this.width / this.squareSize;
        this.width = this.squareSize * this.xBound;
    }

    public int getxBound() {
        return xBound;
    }

    public int getyBound() {
        return yBound;
    }
}
