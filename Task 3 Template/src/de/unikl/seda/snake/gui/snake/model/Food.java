package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;

public class Food extends Updatable implements Hittable {

    private int span = 10;

    public Food(Point location) {
        super(location, Color.YELLOW, FOOD);
    }

    @Override
    public void whenHitting(SnakeGameState snakeGameState) {
        snakeGameState.removeObject(this);
        snakeGameState.addObject(new Food(snakeGameState.generateRandomPoint()));
        snakeGameState.increaseScore();
    }

    @Override
    public void update(SnakeGameState snakeGameState) {
        if (span == 0) {
            System.out.println("delete food");
            snakeGameState.removeObject(this);
            snakeGameState.addObject(new Food(snakeGameState.generateRandomPoint()));
        } else {
            span--;
            System.out.println("decrease");
        }
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
