package de.unikl.seda.snake.settings;

import de.unikl.seda.snake.gui.tools.ResourceManager;
import de.unikl.seda.snake.gui.snake.enums.GameLevel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SnakeGameSettingsAdjuster implements Serializable {

    public final static int SLOW = 1;
    public final static int MEDIUM = 2;
    public final static int FAST = 3;

    public final static int SMALL = 1;
    public final static int REGULAR = 2;
    public final static int BIG = 3;

    private final static int speedBias = 100;

    private final static int speedNorm = 25;
    private final static int heightNorm = 9 * 30;
    private final static int widthNorm = 16 * 30;
    private final static int pixelNorm = 20;
    private final static Map<Integer, GameLevel> gameLevelMap;

    static {
        gameLevelMap = new HashMap<>();
        for (GameLevel gameLevel : GameLevel.values()) {
            gameLevelMap.put(gameLevel.getConst(), gameLevel);
        }
    }

    private transient SnakeGameSettings snakeGameSettings;

    private String playerName;
    private int gameLevel;
    private int speedLevel;
    private int screenSize;
    private boolean soundEnabled;
    private int numOfFoods;
    private boolean poopMode;

    public SnakeGameSettingsAdjuster(SnakeGameSettings snakeGameSettings) {
        this.snakeGameSettings = snakeGameSettings;
        setPlayerName("duc");
        setGameLevel(1);
        setSpeedLevel(1);
        setSoundEnabled(true);
        setNumOfFoods(1);
        setPoopMode(true);
        setScreenSize(1);
        SettingsPersistentHandler.writeSettings(this);
    }

    public void setupSnakeGameSettings(SnakeGameSettings snakeGameSettings) {
        this.snakeGameSettings = snakeGameSettings;
        snakeGameSettings.setGameLevel(gameLevelMap.get(this.gameLevel));
        snakeGameSettings.setGameSpeed(speedBias - speedLevel * speedNorm);
        snakeGameSettings.setSquareSize(screenSize * pixelNorm);
        snakeGameSettings.setWidth(screenSize * widthNorm);
        snakeGameSettings.setHeight(screenSize * heightNorm);
        snakeGameSettings.setSoundEnabled(soundEnabled);
        ResourceManager.setSoundEnable(soundEnabled);
        snakeGameSettings.setNumOfFoods(this.numOfFoods);
        snakeGameSettings.setPoopMode(poopMode);
        snakeGameSettings.setPlayerName(this.playerName);
    }

    public boolean saveSettings() {
        return SettingsPersistentHandler.writeSettings(this);
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(int gameLevel) {
        this.gameLevel = gameLevel;
        snakeGameSettings.setGameLevel(gameLevelMap.get(this.gameLevel));
        SettingsPersistentHandler.writeSettings(this);
    }

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        this.speedLevel = speedLevel;
        snakeGameSettings.setGameSpeed(speedBias - speedLevel * speedNorm);
        SettingsPersistentHandler.writeSettings(this);
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        snakeGameSettings.setSquareSize(screenSize * pixelNorm);
        snakeGameSettings.setWidth(screenSize * widthNorm);
        snakeGameSettings.setHeight(screenSize * heightNorm);
        SettingsPersistentHandler.writeSettings(this);
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
        snakeGameSettings.setSoundEnabled(soundEnabled);
        ResourceManager.setSoundEnable(soundEnabled);
        SettingsPersistentHandler.writeSettings(this);
    }

    public void setNumOfFoods(int numOfFoods) {
        this.numOfFoods = numOfFoods;
        snakeGameSettings.setNumOfFoods(this.numOfFoods);
        SettingsPersistentHandler.writeSettings(this);
    }

    public int getNumOfFoods() {
        return numOfFoods;
    }

    public void setPoopMode(boolean poopMode) {
        this.poopMode = poopMode;
        snakeGameSettings.setPoopMode(poopMode);
        SettingsPersistentHandler.writeSettings(this);
    }

    public boolean getPoopMode() {
        return poopMode;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        snakeGameSettings.setPlayerName(this.playerName);
        SettingsPersistentHandler.writeSettings(this);
    }

    public String getPlayerName() {
        return playerName;
    }
}
