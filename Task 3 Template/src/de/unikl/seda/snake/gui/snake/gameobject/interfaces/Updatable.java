package de.unikl.seda.snake.gui.snake.gameobject.interfaces;

import de.unikl.seda.snake.gui.tools.GameObjectManager;
import de.unikl.seda.snake.gui.snake.gameobject.Point;

import java.awt.*;

public abstract class Updatable extends GameObject implements Comparable {

    private static final int BASE = 0;
    protected static final int SNAKE_HEAD = BASE + 1;
    private static int FOOD = SNAKE_HEAD + 1;
    private static int SNAKE_BODY = FOOD + 1;

    protected static int getFoodProperty() {
        SNAKE_BODY++;
        return FOOD++;
    }

    protected static int getSnakeBodyProperty() {
        return SNAKE_BODY++;
    }

    private int priority;

    public Updatable(Point location, Color color, int priority) {
        super(location, color);
        this.priority = priority;
    }

    public abstract void update(GameObjectManager gameObjectManager);

    private int getPriority() {
        return this.priority;
    }

    @Override
    public int compareTo(Object o) {
        return this.priority - ((Updatable) o).getPriority();
    }
}
