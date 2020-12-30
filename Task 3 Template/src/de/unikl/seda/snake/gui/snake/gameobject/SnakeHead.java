package de.unikl.seda.snake.gui.snake.gameobject;

import de.unikl.seda.snake.gui.tools.RessourcesManager;
import de.unikl.seda.snake.gui.tools.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.gameobject.enums.Direction;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Updatable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;
import static de.unikl.seda.snake.gui.snake.gameobject.enums.Direction.*;

public class SnakeHead extends Updatable {

    // The snake is not moving, facing right
    private Direction currentDirection = IDLE;

    public SnakeHead(Point location) {
        super(location, Color.RED, SNAKE_HEAD);
    }

    @Override
    public void update(SnakeGameState snakeGameState) {
        int currentX = snakeGameState.getSnakeHead().getLocation().getX();
        int currentY = snakeGameState.getSnakeHead().getLocation().getY();
        int oldX = currentX;
        int oldY = currentY;
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
        if (currentDirection != IDLE) {
            SnakeBody bodyToAdd = new SnakeBody(new Point(oldX, oldY));
            snakeGameState.getSnakeBody().add(bodyToAdd);
            snakeGameState.addObject(bodyToAdd);
        }
    }

    @Override
    public void draw(Graphics2D graphics, SnakeGameSettings gameSettings) {
//        graphics.setColor(color);
//        graphics.fillRoundRect(location.getX() * gameSettings.getSquareSize(),
//                location.getY() * gameSettings.getSquareSize() + GAME_INFO_BANNER_HEIGHT,
//                gameSettings.getSquareSize(),
//                gameSettings.getSquareSize(),
//                gameSettings.getSquareSize(),
//                gameSettings.getSquareSize());

        graphics.drawImage(RessourcesManager.getImage(this.currentDirection.imageCode()),
                location.getX() * gameSettings.getSquareSize(),
                location.getY() * gameSettings.getSquareSize() + GAME_INFO_BANNER_HEIGHT,
                gameSettings.getSquareSize(),
                gameSettings.getSquareSize(),
                null);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
