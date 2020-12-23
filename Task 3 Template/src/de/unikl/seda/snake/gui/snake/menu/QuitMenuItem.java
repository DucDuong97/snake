package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Selectable;

public class QuitMenuItem implements Selectable {
    @Override
    public void selected(SnakeGameEnvironment snakeGameEnvironment) {
        //TODO
    }

    @Override
    public String getName() {
        return "Quit";
    }
}
