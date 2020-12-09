package de.unikl.seda.snake.gui.snake.model.interfaces;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.snake.model.Point;

import java.awt.*;

public abstract class GameObject {

    protected de.unikl.seda.snake.gui.snake.model.Point location;
    protected Color color;

    public GameObject(de.unikl.seda.snake.gui.snake.model.Point location, Color color) {
        this.location = location;
        this.color = color;
    }

    public de.unikl.seda.snake.gui.snake.model.Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics2D graphics, SnakeGameSettings gameSettings);
}
