package de.unikl.seda.snake.gui.snake.model.interfaces;

import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.Point;

public interface Hittable {
    Point getLocation();
    void hitted(SnakeGameState snakeGameState);
}
