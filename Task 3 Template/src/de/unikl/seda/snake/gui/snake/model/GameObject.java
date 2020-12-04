package de.unikl.seda.snake.gui.snake.model;

import de.unikl.seda.snake.gui.snake.SnakeGameSettings;

import java.awt.*;

public abstract class GameObject {

    protected Point location;
    protected Color color;

    public GameObject(Point location, Color color) {
        this.location = location;
        this.color = color;
    }

    public Point getLocation() {
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
