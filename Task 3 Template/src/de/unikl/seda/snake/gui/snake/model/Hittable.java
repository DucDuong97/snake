package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameState;

import java.awt.*;

public interface Hittable {
    void hitted(SnakeGameState snakeGameState);
}
