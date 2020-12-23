package de.unikl.seda.snake.gui.snake.menu.interfaces;

import de.unikl.seda.snake.gui.snake.SnakeGameSettingsAdjuster;

public abstract class Adjustable implements MenuItem {
    protected SnakeGameSettingsAdjuster snakeGameSettingsAdjuster;

    public Adjustable(SnakeGameSettingsAdjuster snakeGameSettingsAdjuster) {
        this.snakeGameSettingsAdjuster = snakeGameSettingsAdjuster;
    }

    public abstract int getValue();
    public abstract void increase();
    public abstract void decrease();
}
