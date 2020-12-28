package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameSettingsAdjuster;
import de.unikl.seda.snake.gui.snake.enums.GameLevel;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Adjustable;

public class LevelMenuItem extends Adjustable {
    private int level;
    public LevelMenuItem(SnakeGameSettingsAdjuster snakeGameSettingsAdjuster) {
        super(snakeGameSettingsAdjuster);
        this.level = snakeGameSettingsAdjuster.getGameLevelLevel();
    }

    @Override
    public double getValue() {
        return level;
    }

    @Override
    public void increase() {
        switch(level) {
            case 0:
                level++;
                snakeGameSettingsAdjuster.setGameLevel(GameLevel.VERTICAL_LINES);
                break;
            case 1:
                level++;
                snakeGameSettingsAdjuster.setGameLevel(GameLevel.BOX);
                break;
            case 2:
                level = 0;
                snakeGameSettingsAdjuster.setGameLevel(GameLevel.NO_BORDER);
                break;
        }
        System.out.println(snakeGameSettingsAdjuster.getSnakeGameSettings().getGameLevel());
    }

    @Override
    public void decrease() {
        switch(level) {
            case 0:
                level = 2;
                snakeGameSettingsAdjuster.setGameLevel(GameLevel.BOX);
                break;
            case 1:
                level--;
                snakeGameSettingsAdjuster.setGameLevel(GameLevel.NO_BORDER);
                break;
            case 2:
                level--;
                snakeGameSettingsAdjuster.setGameLevel(GameLevel.VERTICAL_LINES);
                break;
        }
        System.out.println(snakeGameSettingsAdjuster.getSnakeGameSettings().getGameLevel());
    }

    @Override
    public String getName() {
        return "level";
    }
}
