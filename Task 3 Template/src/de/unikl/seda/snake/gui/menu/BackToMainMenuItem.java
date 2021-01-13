package de.unikl.seda.snake.gui.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.menu.interfaces.Selectable;
import de.unikl.seda.snake.gui.tools.RessourcesManager;

public class BackToMainMenuItem implements Selectable {
    @Override
    public void selected(SnakeGameEnvironment snakeGameEnvironment) {
        RessourcesManager.stopBackgroundSound();
        snakeGameEnvironment.goToGameMenu();
    }

    @Override
    public String getName() {
        return "back to main menu";
    }
}
