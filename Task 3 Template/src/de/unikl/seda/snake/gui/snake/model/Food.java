package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameState;

import java.awt.*;

public class Food extends GameObject implements Hittable {

    public Food(Point location) {
        super(location, Color.YELLOW);
    }

    @Override
    public void hitted(SnakeGameState snakeGameState) {

    }
}
