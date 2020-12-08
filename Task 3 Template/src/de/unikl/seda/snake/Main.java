package de.unikl.seda.snake;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.SnakeGameSettings;
import de.unikl.seda.snake.gui.tools.GuiContainer;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        SnakeGameSettings snakeGameSettings = new SnakeGameSettings();

        System.out.println("²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²");
        System.out.println("G-Snake");
        System.out.println("²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²²\n");

        System.out.println("-------------------------------------------\n");
        System.out.println("Game Menu Overview\n");

        System.out.println("[1] Start");
        System.out.println("[2] Settings");
        System.out.println("[3] Exit\n");
        System.out.print("> Select: ");

        int userInput = s.nextInt();
        switch(userInput) {
            case 1:
                startGame(snakeGameSettings);
                break;
            case 2:
                gameSettings(snakeGameSettings);
                break;
            case 3: break;
        }
    }

    private static void startGame(SnakeGameSettings snakeGameSettings) {

        /*System.out.print("Input player name: ");
        String playerName = s.next();
        snakeGameSettings.setPlayerName(playerName);

        System.out.print("Input square size in pixels: ");
        int pixel = s.nextInt();

        // set the pixel for the snakeGameSettings object
        snakeGameSettings.setSquareSize(pixel);*/

        System.out.println("Game Level Selection: ");
        System.out.println("[1]: Level 1");
        System.out.println("[2]: Level 2");
        System.out.println("[3]: Level 3");
        System.out.print("> Select a game level: ");
        int userLevel = s.nextInt();

        switch(userLevel){
            case 1:
                snakeGameSettings.setGameLevel(SnakeGameSettings.GameLevel.NO_BORDER);
                break;
            case 2:
                snakeGameSettings.setGameLevel(SnakeGameSettings.GameLevel.BOX);
                break;
            case 3: snakeGameSettings.setGameLevel(SnakeGameSettings.GameLevel.VERTICAL_LINES);
        }

        // Create game instance
        startGameInstance(snakeGameSettings);
    }
    private static void gameSettings(SnakeGameSettings snakeGameSettings){

        System.out.println("[1] Square size");
        System.out.println("[2] Player name");
        System.out.println("[3] Game speed\n");
        System.out.print("> Select: ");

        int userInput = s.nextInt();
        switch (userInput) {
            case 1:
                // Change Square size
                System.out.print("Enter the square size: ");
                int squareSize = s.nextInt();
                snakeGameSettings.setSquareSize(squareSize);
            case 2:
                // Change player name
                System.out.print("Enter your new player name: ");
                String playerName = s.next();
                snakeGameSettings.setPlayerName(playerName);
            case 3:
                // Change game speed
                System.out.print("Enter the new game speed: ");
                int gameSpeed = s.nextInt();
                snakeGameSettings.setGameSpeed(gameSpeed);
        }
        startGameInstance(snakeGameSettings);

    }

    private static void startGameInstance(SnakeGameSettings snakeGameSettings) {
        // Create game instance
        SnakeGameEnvironment game = new SnakeGameEnvironment(snakeGameSettings);
        // Start game session
        GuiContainer.show("Snake", game);
    }
}

