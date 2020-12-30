package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameSettingsAdjuster;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Adjustable;

public class ResolutionMenuItem extends Adjustable {
    private int level;
    public ResolutionMenuItem(SnakeGameSettingsAdjuster snakeGameSettingsAdjuster) {
        super(snakeGameSettingsAdjuster);
        this.level = snakeGameSettingsAdjuster.getScreenSize();
    }

    @Override
    public double getValue() {
        return level;
    }

    @Override
    public void increase() {
        if (this.level > 2) {
            return;
        }
        snakeGameSettingsAdjuster.setScreenSize(++this.level);
    }

    @Override
    public void decrease() {
        if (this.level <= 1) {
            return;
        }
        snakeGameSettingsAdjuster.setScreenSize(--level);
    }

    @Override
    public String getName() {
        return "Resolution";
    }
}
