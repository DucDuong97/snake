package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;

public class Wall extends GameObject implements Hittable {
    public Wall(Point location) {
        super(location, Color.BLACK);
    }

    @Override
    public void hitted(SnakeGameState snakeGameState) {
        snakeGameState.setState(SnakeGameState.State.DEAD);
    }


    @Override
    public void draw(Graphics2D graphics, SnakeGameSettings gameSettings) {
        graphics.setColor(color);
        graphics.fillRoundRect(location.getX() * gameSettings.getSquareSize(),
                location.getY() * gameSettings.getSquareSize() + GAME_INFO_BANNER_HEIGHT,
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize(),
                2,
                2);
    }
}
