package de.unikl.seda.snake.gui.snake.gameobject;

import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Updatable;
import de.unikl.seda.snake.gui.tools.ResourceManager;
import de.unikl.seda.snake.gui.tools.SnakeGameDrawer;
import de.unikl.seda.snake.gui.tools.GameObjectManager;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.GameObject;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Hittable;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.enums.Direction.IDLE;

public class SnakeBody extends SnakeHead implements Hittable {

    protected SnakeHead successor;

    public SnakeBody(Point location, SnakeHead successor) {
        super(location);
        setPriority(getSnakeBodyProperty());
        this.successor = successor;
        setCurrentDirection(successor.getCurrentDirection());
    }

    @Override
    public void whenHitting(GameObjectManager gameObjectManager) {
        gameObjectManager.dead();
    }

    @Override
    public void update(GameObjectManager gameObjectManager) {
        if (gameObjectManager.getSnakeHead().getCurrentDirection() == IDLE) {
            return;
        }
        setCurrentDirection(successor.getCurrentDirection());
//        setLocation(successor.getLocation());
        Point currentLocation = getLocation();
        currentLocation.setX(successor.getLocation().getX());
        currentLocation.setY(successor.getLocation().getY());

        System.out.println(location.getX() + " " + location.getY());
        System.out.println(getCurrentDirection());
    }

    @Override
    public void draw(SnakeGameDrawer snakeGameDrawer) {
        //TODO
        snakeGameDrawer.drawImage(ResourceManager.getImage(ResourceManager.SNAKE_BODY), this.location);
    }
}
