package de.unikl.seda.snake.gui.snake.model.interfaces;

import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.snake.model.GameObject;
import de.unikl.seda.snake.gui.snake.model.Point;

import java.awt.*;

public abstract class Updatable extends GameObject implements Comparable {

    private static final int BASE = 0;
    protected static final int SNAKE_HEAD = BASE + 1;
    protected static final int FOOD = SNAKE_HEAD + 1;

    private final int priority;

    public Updatable(Point location, Color color, int priority) {
        super(location, color);
        this.priority = priority;
    }

    public abstract void update(SnakeGameState snakeGameState);

    private int getPriority() {
        return this.priority;
    }

    @Override
    public int compareTo(Object o) {
        return this.priority - ((Updatable) o).getPriority();
    }
}
