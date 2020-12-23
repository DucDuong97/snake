package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.enums.Direction;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;
import static de.unikl.seda.snake.gui.snake.model.enums.Direction.*;

public class SnakeHead extends Updatable {

    private Direction currentDirection = IDLE;

    public SnakeHead(Point location) {
        super(location, Color.RED, SNAKE_HEAD);
    }

    @Override
    public void update(SnakeGameState snakeGameState) {
        int currentX = snakeGameState.getSnakeHead().getLocation().getX();
        int currentY = snakeGameState.getSnakeHead().getLocation().getY();
        switch(currentDirection) {
            case UP:
                currentY = currentY - 1;
                if (currentY < 0) {
                    currentY = snakeGameState.getGameSettings().getyBound() - 1;
                }
                snakeGameState.getSnakeHead().getLocation().setY(currentY);
                break;
            case DOWN:
                currentY = currentY + 1;
                if (currentY > snakeGameState.getGameSettings().getyBound() - 1) {
                    currentY = 0;
                }
                snakeGameState.getSnakeHead().getLocation().setY(currentY);
                break;
            case LEFT:
                currentX = currentX - 1;
                if (currentX < 0) {
                    currentX = snakeGameState.getGameSettings().getxBound() - 1;
                }
                snakeGameState.getSnakeHead().getLocation().setX(currentX);
                break;
            case RIGHT:
                currentX = currentX + 1;
                if (currentX > snakeGameState.getGameSettings().getxBound() - 1) {
                    currentX = 0;
                }
                snakeGameState.getSnakeHead().getLocation().setX(currentX);
                break;
            case IDLE:
                break;
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

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
