package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;

import java.awt.*;

public class Wall extends GameObject implements Hittable {
    public Wall(Point location) {
        super(location, Color.BLACK);
    }

    @Override
    public void hitted(SnakeGameState snakeGameState) {
        //TODO
    }

    @Override
    public void draw(Graphics2D graphics, SnakeGameSettings gameSettings) {
        //TODO
    }
}
