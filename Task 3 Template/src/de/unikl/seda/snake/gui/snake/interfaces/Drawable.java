package de.unikl.seda.snake.gui.snake.interfaces;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;

import java.awt.*;

public interface Drawable {
    public abstract void draw(Graphics2D graphics, SnakeGameSettings gameSettings);
}
