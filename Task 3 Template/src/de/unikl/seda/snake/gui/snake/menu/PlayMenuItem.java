package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Selectable;

import static de.unikl.seda.snake.gui.snake.enums.MainState.IN_GAME;

public class PlayMenuItem implements Selectable {

    @Override
    public void selected(SnakeGameEnvironment snakeGameEnvironment) {
        snakeGameEnvironment.setMainState(IN_GAME);
    }

    @Override
    public String getName() {
        return "Play";
    }
}
