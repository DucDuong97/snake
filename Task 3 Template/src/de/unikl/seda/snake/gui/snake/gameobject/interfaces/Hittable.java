package de.unikl.seda.snake.gui.snake.gameobject.interfaces;

import de.unikl.seda.snake.gui.snake.SnakeGameState;

public interface Hittable {
    void whenHitting(SnakeGameState snakeGameState);
}
