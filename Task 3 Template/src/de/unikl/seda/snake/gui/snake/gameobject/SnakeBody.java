package de.unikl.seda.snake.gui.snake.gameobject;

import de.unikl.seda.snake.gui.tools.RessourcesManager;
import de.unikl.seda.snake.gui.tools.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.enums.State;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.GameObject;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Hittable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;

public class SnakeBody extends GameObject implements Hittable {

    public SnakeBody(Point location) {
        super(location, Color.ORANGE);
    }

    @Override
    public void whenHitting(SnakeGameState snakeGameState) {
        snakeGameState.setState(State.DEAD);
    }


    @Override
    public void draw(Graphics2D graphics, SnakeGameSettings gameSettings) {
        /*
        graphics.setColor(color);
        graphics.fillRoundRect(location.getX() * gameSettings.getSquareSize(),
                location.getY() * gameSettings.getSquareSize() + GAME_INFO_BANNER_HEIGHT,
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize());
        */


        graphics.drawImage(RessourcesManager.getImage(5),
                location.getX() * gameSettings.getSquareSize(),
                location.getY() * gameSettings.getSquareSize() + GAME_INFO_BANNER_HEIGHT,
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize(),
                null);
    }
}
