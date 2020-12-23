package de.unikl.seda.snake;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.tools.GuiContainer;

import java.util.Scanner;

import static de.unikl.seda.snake.gui.snake.enums.GameLevel.*;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        SnakeGameEnvironment game = new SnakeGameEnvironment();
        // Start game session
        GuiContainer.show("Snake", game);
    }
}

