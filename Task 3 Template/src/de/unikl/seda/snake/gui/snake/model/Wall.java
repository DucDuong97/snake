package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameState;

import java.awt.*;

public class Wall extends GameObject implements Hittable {
    public Wall(Point location) {
        super(location, Color.BLACK);
    }

    @Override
    public void hitted(SnakeGameState snakeGameState) {

    }
}
