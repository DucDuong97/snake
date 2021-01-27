package de.unikl.seda.snake.gui.menu;

import de.unikl.seda.snake.settings.SnakeGameSettingsAdjuster;
import de.unikl.seda.snake.gui.menu.interfaces.Adjustable;

public class SpeedMenuItem extends Adjustable {

    private int level;

    public SpeedMenuItem(SnakeGameSettingsAdjuster snakeGameSettingsAdjuster) {
        super(snakeGameSettingsAdjuster);
        this.level = snakeGameSettingsAdjuster.getSpeedLevel();
    }

    @Override
    public double getValue() {
        return level;
    }

    @Override
    public void increase() {
        if (level < 3) {
            snakeGameSettingsAdjuster.setSpeedLevel(++level);
        }
    }

    @Override
    public void decrease() {
        if (level > 1) {
            snakeGameSettingsAdjuster.setSpeedLevel(--level);
        }
    }

    @Override
    public String getName() {
        return "Speed";
    }
}
