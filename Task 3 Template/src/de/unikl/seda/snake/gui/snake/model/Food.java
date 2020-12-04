package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;

import java.awt.*;

public class Food extends GameObject implements Hittable, Updatable {

    public Food(Point location) {
        super(location, Color.YELLOW);
    }

    @Override
    public void hitted(SnakeGameState snakeGameState) {
        //TODO
    }

    @Override
    public void update(SnakeGameState snakeGameState) {
        //TODO
    }

    @Override
    public void draw(Graphics2D graphics, SnakeGameSettings gameSettings) {
        //TODO
    }
}
