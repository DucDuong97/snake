package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.enums.GameLevel;
import de.unikl.seda.snake.gui.tools.GameEnvironment;

import static de.unikl.seda.snake.gui.snake.enums.GameLevel.*;

public class SnakeGameSettings {

    private String playerName;
    private GameLevel gameLevel;
    private int gameSpeed;

    private int squareSize;
    private int height;
    private int width;
    private int xBound;
    private int yBound;

    private GameEnvironment gameEnvironment;

    public SnakeGameSettings(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
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
        gameEnvironment.setGameSpeed(this.gameSpeed);
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
        this.yBound = height / this.squareSize;
        this.height = this.squareSize * this.yBound;
        gameEnvironment.setHeight(this.height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.xBound = width / this.squareSize;
        this.width = this.squareSize * this.xBound;
        gameEnvironment.setWidth(this.width);
    }

    public int getxBound() {
        return xBound;
    }

    public int getyBound() {
        return yBound;
    }
}
