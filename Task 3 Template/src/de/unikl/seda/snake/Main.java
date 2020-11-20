package de.unikl.seda.snake;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.tools.GuiContainer;

public class Main {
    public static void main(String[] args) {

        //TODO implement console input 1

        // Create game instance
        SnakeGameEnvironment game = new SnakeGameEnvironment(800, 600, "Duc", 50);

        // Start game session
        GuiContainer.show("Snake", game);}
}

