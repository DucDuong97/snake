package de.unikl.seda.snake;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.tools.GuiContainer;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

        //TODO implement console input 1

        System.out.println("²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²");
        System.out.println("G-Snake");
        System.out.println("²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");

        System.out.println("-------------------------------------------");
        System.out.println("[1] Start");
        System.out.println("[0] Exit\n");
        System.out.print("> Select: ");

        int userInput = s.nextInt();
        switch(userInput) {
            case 1: startGame();
            case 0: break;
        }
    }

    private static void startGame() {

        System.out.print("Input player name: ");
        String userName = s.nextLine();
        System.out.print("Input square size in pixels: ");
        int squareSize = s.nextInt();

        // Create game instance
        //SnakeGameEnvironment game = new SnakeGameEnvironment(800, 600, "Duc", 50);
        SnakeGameEnvironment game = new SnakeGameEnvironment(800, 600, userName, squareSize);

        // Start game session
        GuiContainer.show("Snake", game);
    }
}

