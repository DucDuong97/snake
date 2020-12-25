package de.unikl.seda.snake.gui.snake.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.enums.MainState;
import de.unikl.seda.snake.gui.snake.menu.interfaces.Selectable;

public class ResumeMenuItem implements Selectable {
    @Override
    public void selected(SnakeGameEnvironment snakeGameEnvironment) {
        snakeGameEnvironment.setMainState(MainState.IN_GAME);
    }

    @Override
    public String getName() {
        return "resume";
    }
}
