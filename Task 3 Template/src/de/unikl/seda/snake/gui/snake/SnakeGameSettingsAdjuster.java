package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.enums.GameLevel;
import de.unikl.seda.snake.gui.tools.GuiContainer;

import java.util.HashMap;
import java.util.Map;

//TODO set limits
public class SnakeGameSettingsAdjuster {

    public final static int SLOW = 1;
    public final static int MEDIUM = 2;
    public final static int FAST = 3;

    public final static int SMALL = 1;
    public final static int REGULAR = 2;
    public final static int BIG = 3;

    private final static int speedNorm = 150;
    private final static int heightNorm = 300;
    private final static int widthNorm = 400;
    private final static int pixelNorm = 20;
    private final static Map<Integer, GameLevel> gameLevelMap;

    static {
        gameLevelMap = new HashMap<>();
        for (GameLevel gameLevel : GameLevel.values()) {
            gameLevelMap.put(gameLevel.getConst(), gameLevel);
        }
    }

    private SnakeGameSettings snakeGameSettings;

    private int gameLevel;
    private int speedLevel;
    private int screenSize;

    public SnakeGameSettingsAdjuster(SnakeGameSettings snakeGameSettings) {
        this.snakeGameSettings = snakeGameSettings;
        setGameLevel(1);
        setSpeedLevel(1);
        setScreenSize(1);
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
        snakeGameSettings.setGameLevel(gameLevelMap.get(gameLevel));
    }

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        this.speedLevel = speedLevel;
        snakeGameSettings.setGameSpeed(speedLevel * speedNorm);
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        snakeGameSettings.setSquareSize(screenSize * pixelNorm);
        snakeGameSettings.setWidth(screenSize * widthNorm);
        snakeGameSettings.setHeight(screenSize * heightNorm);
    }
}
