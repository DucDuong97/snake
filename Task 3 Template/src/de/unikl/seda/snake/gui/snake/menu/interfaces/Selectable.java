package de.unikl.seda.snake.gui.snake.menu.interfaces;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;

public interface Selectable extends MenuItem {
    public void selected(SnakeGameEnvironment snakeGameEnvironment);
}
