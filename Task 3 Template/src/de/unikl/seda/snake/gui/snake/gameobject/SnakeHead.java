package de.unikl.seda.snake.gui.snake.gameobject;

import de.unikl.seda.snake.gui.tools.ResourceManager;
import de.unikl.seda.snake.gui.tools.SnakeGameDrawer;
import de.unikl.seda.snake.gui.tools.GameObjectManager;
import de.unikl.seda.snake.gui.snake.enums.Direction;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Updatable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.enums.Direction.*;

public class SnakeHead extends Updatable {

    // The snake is not moving, facing right
    private Direction currentDirection = IDLE;

    public SnakeHead(Point location) {
        super(location, Color.RED, SNAKE_HEAD);
    }

    @Override
    public void update(GameObjectManager gameObjectManager) {
        int oldX = location.getX();
        int oldY = location.getY();
        currentDirection.update(gameObjectManager);
        if (currentDirection != IDLE) {
            SnakeBody bodyToAdd = new SnakeBody(new Point(oldX, oldY));
            gameObjectManager.getSnakeBody().add(bodyToAdd);
            gameObjectManager.addObject(bodyToAdd);
        }
    }

    @Override
    public void draw(SnakeGameDrawer snakeGameDrawer) {
        snakeGameDrawer.drawImage(ResourceManager.getImage(this.currentDirection.imageCode()), this.location);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
