package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;

public class Food extends GameObject implements Hittable, Updatable {

    int span = 20;

    public Food(Point location) {
        super(location, Color.YELLOW);
    }

    @Override
    public void hitted(SnakeGameState snakeGameState) {
        snakeGameState.getHittableSet().remove(this);
        snakeGameState.getUpdatableSet().remove(this);
        snakeGameState.getObjectSet().remove(this);
        snakeGameState.generateFood();
        snakeGameState.increaseScore();
    }

    @Override
    public void update(SnakeGameState snakeGameState) {
        if (span == 0) {
            snakeGameState.getHittableSet().remove(this);
            snakeGameState.getUpdatableSet().remove(this);
            snakeGameState.getObjectSet().remove(this);
            snakeGameState.generateFood();
            span = 20;
        } else { span--; }
    }

    @Override
    public void draw(Graphics2D graphics, SnakeGameSettings gameSettings) {
        graphics.setColor(color);
        graphics.fillRoundRect(location.getX() * gameSettings.getSquareSize(),
                location.getY() * gameSettings.getSquareSize() + GAME_INFO_BANNER_HEIGHT,
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize());
    }
}
