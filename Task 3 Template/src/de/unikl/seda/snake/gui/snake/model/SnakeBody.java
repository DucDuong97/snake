package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.enums.State;
import de.unikl.seda.snake.gui.snake.model.interfaces.GameObject;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;

public class SnakeBody extends GameObject implements Hittable {

    public SnakeBody(Point location) {
        super(location, Color.ORANGE);
    }

    @Override
    public void whenHitting(SnakeGameState snakeGameState) {
        System.out.println("You hit the body");
        snakeGameState.setState(State.DEAD);
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
