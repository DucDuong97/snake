package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameSettingsAdjuster;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Adjustable;

public class SpeedMenuItem extends Adjustable {

    private int level;

    public SpeedMenuItem(SnakeGameSettingsAdjuster snakeGameSettingsAdjuster) {
        super(snakeGameSettingsAdjuster);
        this.level = snakeGameSettingsAdjuster.getSpeedLevel();
    }

    @Override
    public int getValue() {
        return level;
    }

    @Override
    public void increase() {
        snakeGameSettingsAdjuster.setSpeedLevel(++level);
    }

    @Override
    public void decrease() {
        snakeGameSettingsAdjuster.setSpeedLevel(--level);
    }

    @Override
    public String getName() {
        return "Speed";
    }
}
