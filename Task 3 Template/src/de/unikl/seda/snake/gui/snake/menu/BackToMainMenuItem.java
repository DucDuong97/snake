package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Selectable;

public class BackToMainMenuItem implements Selectable {
    @Override
    public void selected(SnakeGameEnvironment snakeGameEnvironment) {
        snakeGameEnvironment.renewGameState();
    }

    @Override
    public String getName() {
        return "back to main menu";
    }
}