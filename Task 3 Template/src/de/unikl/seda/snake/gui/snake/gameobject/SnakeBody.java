package de.unikl.seda.snake.gui.snake.gameobject;

import de.unikl.seda.snake.gui.tools.ResourceManager;
import de.unikl.seda.snake.gui.tools.SnakeGameDrawer;
import de.unikl.seda.snake.gui.tools.GameObjectManager;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.GameObject;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Hittable;

import java.awt.*;

public class SnakeBody extends GameObject implements Hittable {

    public SnakeBody(Point location) {
        super(location, Color.ORANGE);
    }

    @Override
    public void whenHitting(GameObjectManager gameObjectManager) {
        gameObjectManager.dead();
    }

    @Override
    public void draw(SnakeGameDrawer snakeGameDrawer) {
        snakeGameDrawer.drawImage(ResourceManager.getImage(ResourceManager.SNAKE_BODY), this.location);
    }
}
