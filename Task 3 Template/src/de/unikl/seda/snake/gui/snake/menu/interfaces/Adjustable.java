package de.unikl.seda.snake.gui.snake.menu.interfaces;

import de.unikl.seda.snake.gui.tools.SnakeGameSettingsAdjuster;

public abstract class Adjustable implements MenuItem {
    protected SnakeGameSettingsAdjuster snakeGameSettingsAdjuster;

    public Adjustable(SnakeGameSettingsAdjuster snakeGameSettingsAdjuster) {
        this.snakeGameSettingsAdjuster = snakeGameSettingsAdjuster;
    }

    public abstract double getValue();
    public abstract void increase();
    public abstract void decrease();
}
