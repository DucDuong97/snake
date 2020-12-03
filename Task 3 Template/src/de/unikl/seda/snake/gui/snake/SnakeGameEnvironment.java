package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.model.GameObject;
import de.unikl.seda.snake.gui.snake.model.Hittable;
import de.unikl.seda.snake.gui.snake.model.Point;
import de.unikl.seda.snake.gui.tools.GameEnvironment;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameState.Direction.*;
import static de.unikl.seda.snake.gui.snake.SnakeGameState.State.DEAD;

public class SnakeGameEnvironment extends GameEnvironment {

    private static final int GAME_INFO_BANNER_HEIGHT = 25;
    private static final int INFO_HEIGHT = 18;

    private SnakeGameState snakeGameState;
    private SnakeGameSettings snakeGameSettings;

    // Coordination
    private int xCells;
    private int yCells;

    public SnakeGameEnvironment(SnakeGameSettings snakeGameSettings) {
        // sets the size of the snake environment
        super(snakeGameSettings.getSquareSize() *(snakeGameSettings.getWidth() / snakeGameSettings.getSquareSize()),
                snakeGameSettings.getSquareSize() *(snakeGameSettings.getHeight() / snakeGameSettings.getSquareSize()) + GAME_INFO_BANNER_HEIGHT,
                snakeGameSettings.getGameSpeed());
        this.snakeGameSettings = snakeGameSettings;
        this.xCells = getWidth() / snakeGameSettings.getSquareSize();
        this.yCells = (getHeight() - GAME_INFO_BANNER_HEIGHT) / snakeGameSettings.getSquareSize();
        this.snakeGameState = new SnakeGameState(snakeGameSettings.getGameLevel());
        snakeGameState.setSnakeHead(new GameObject(new Point(0, 0), Color.RED));
    }

    //TODO movement behavior 1.1
    @Override
    protected void handleKeypressUp() {
        snakeGameState.setCurrentDirection(UP);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleKeypressDown() {
        snakeGameState.setCurrentDirection(DOWN);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleKeypressLeft() {
        snakeGameState.setCurrentDirection(LEFT);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleKeypressRight() {
        snakeGameState.setCurrentDirection(RIGHT);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleReturnPress() {
        if (snakeGameState.getSnakeHead().getColor() == Color.RED) {
            snakeGameState.getSnakeHead().setColor(Color.BLUE);
        } else {
            snakeGameState.getSnakeHead().setColor(Color.RED);
        }
        System.out.println("New color is " + snakeGameState.getSnakeHead().getColor().toString());
    }

    @Override
    protected void drawSnakeEnvironment(Graphics2D graphics) {
        // draw header
        graphics.setColor(new Color(125, 167, 116));
        graphics.fillRect(0,0,this.getWidth(), GAME_INFO_BANNER_HEIGHT);
        graphics.setColor(Color.BLACK);
        graphics.drawString(snakeGameSettings.getPlayerName(), 10, INFO_HEIGHT);
        graphics.drawString("Score: " + snakeGameState.getScore(), getWidth() - 80, INFO_HEIGHT);

        // draw grid
        int y = GAME_INFO_BANNER_HEIGHT;
        while (y <= getHeight()) {
            int x = 0;
            while (x <= getWidth()) {
                graphics.drawRect(x, y, snakeGameSettings.getSquareSize(), snakeGameSettings.getSquareSize());
                x += snakeGameSettings.getSquareSize();
            }
            y += snakeGameSettings.getSquareSize();
        }

        // draw snake
        drawGameObject(snakeGameState.getSnakeHead(), graphics);

        //TODO draw food

        //TODO draw wall
    }

    private void drawGameObject(GameObject gameObject, Graphics2D graphics) {
        graphics.setColor(gameObject.getColor());
        graphics.fillRect(gameObject.getLocation().getX() * snakeGameSettings.getSquareSize(),
                gameObject.getLocation().getY() * snakeGameSettings.getSquareSize() + GAME_INFO_BANNER_HEIGHT,
                snakeGameSettings.getSquareSize(), snakeGameSettings.getSquareSize());
    }

    public void updateState() {
        // game over
        if (snakeGameState.getState() == DEAD) {
            return;
        }
        moveForward();
        Hittable hittable = collision();
        if (hittable != null) {
            hittable.hitted(snakeGameState);
        }
    }

    //TODO food placement 1.2
    private void generateFood() {
        // generate a random Point
        // check if this point is available
        // add it to object list in gameState
    }

    //TODO collision detection 1.3
    private Hittable collision() {
        return null;
    }

     private void moveForward() {
        int currentX = snakeGameState.getSnakeHead().getLocation().getX();
        int currentY = snakeGameState.getSnakeHead().getLocation().getY();
        switch(snakeGameState.getCurrentDirection()) {
            case UP:
                currentY = currentY - 1;
                if (currentY < 0) {
                    currentY = yCells - 1;
                }
                snakeGameState.getSnakeHead().getLocation().setY(currentY);
                break;
            case DOWN:
                currentY = currentY + 1;
                if (currentY > yCells - 1) {
                    currentY = 0;
                }
                snakeGameState.getSnakeHead().getLocation().setY(currentY);
                break;
            case LEFT:
                currentX = currentX - 1;
                if (currentX < 0) {
                    currentX = xCells - 1;
                }
                snakeGameState.getSnakeHead().getLocation().setX(currentX);
                break;
            case RIGHT:
                currentX = currentX + 1;
                if (currentX > xCells - 1) {
                    currentX = 0;
                }
                snakeGameState.getSnakeHead().getLocation().setX(currentX);
                break;
            case IDLE:
                break;
        }
    }
}
