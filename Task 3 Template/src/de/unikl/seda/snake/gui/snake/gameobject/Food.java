package de.unikl.seda.snake.gui.snake.gameobject;

import de.unikl.seda.snake.gui.tools.ResourceManager;
import de.unikl.seda.snake.gui.tools.SnakeGameDrawer;
import de.unikl.seda.snake.gui.tools.GameObjectManager;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Updatable;

import java.awt.*;

public class Food extends Updatable implements Hittable {

    private int span = 50;

    public Food(Point location) {
        super(location, Color.YELLOW, getFoodProperty());
    }

    @Override
    public void whenHitting(GameObjectManager gameObjectManager) {
        gameObjectManager.removeObject(this);
        gameObjectManager.addObject(new Food(gameObjectManager.generateRandomPoint()));
        gameObjectManager.increaseScore();
        ResourceManager.playSound(ResourceManager.FOOD_EATEN);

        gameObjectManager.setPoop(gameObjectManager.isPoopMode());
    }

    @Override
    public void update(GameObjectManager gameObjectManager) {
        if (span == 0) {
            gameObjectManager.removeObject(this);
            gameObjectManager.addObject(new Food(gameObjectManager.generateRandomPoint()));
        } else {
            span--;
        }
        System.out.println(span);
    }

    @Override
    public void draw(SnakeGameDrawer snakeGameDrawer) {
        snakeGameDrawer.drawImage(ResourceManager.getImage(ResourceManager.FOOD), this.location);
    }
}
