package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Selectable;



public class GameOverMenuItem implements Selectable {
    @Override
    // Back to main menu with a new SnakeGameState but retain the settings
    public void selected(SnakeGameEnvironment snakeGameEnvironment) {
        snakeGameEnvironment.goToGameMenu();
    }

    @Override
    public String getName() {
        return "game over";
    }
}
