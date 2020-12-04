package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.model.GameObject;
import de.unikl.seda.snake.gui.snake.model.SnakeHead;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.model.Point;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;
import de.unikl.seda.snake.gui.tools.GameEnvironment;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.model.SnakeHead.Direction.*;
import static de.unikl.seda.snake.gui.snake.SnakeGameState.State.DEAD;

public class SnakeGameEnvironment extends GameEnvironment {

    // For UI
    public static final int GAME_INFO_BANNER_HEIGHT = 25;
    private static final int INFO_HEIGHT = 18;

    private SnakeGameState snakeGameState;
    private SnakeGameSettings snakeGameSettings;

    // Coordination

    public SnakeGameEnvironment(SnakeGameSettings snakeGameSettings) {
        // sets the size of the snake environment
        super(snakeGameSettings.getWidth(), snakeGameSettings.getHeight() + GAME_INFO_BANNER_HEIGHT, snakeGameSettings.getGameSpeed());
        this.snakeGameSettings = snakeGameSettings;
        this.snakeGameState = new SnakeGameState(snakeGameSettings);
    }

    //TODO movement behavior 1.1
    @Override
    protected void handleKeypressUp() {
        snakeGameState.getSnakeHead().setCurrentDirection(UP);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleKeypressDown() {
        snakeGameState.getSnakeHead().setCurrentDirection(DOWN);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleKeypressLeft() {
        snakeGameState.getSnakeHead().setCurrentDirection(LEFT);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleKeypressRight() {
        snakeGameState.getSnakeHead().setCurrentDirection(RIGHT);
        uiUpdateThread.interrupt();
    }

    @Override
    protected void handleReturnPress() {
        if (snakeGameState.getSnakeHead().getColor() == Color.RED) {
            snakeGameState.getSnakeHead().setColor(Color.BLUE);
        } else {
            snakeGameState.getSnakeHead().setColor(Color.RED);
        }
    }

    @Override
    protected void drawSnakeEnvironment(Graphics2D graphics) {
        // draw Info Banner
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

        // draw Objects
        this.snakeGameState.getObjectSet().forEach(gameObject -> gameObject.draw(graphics, snakeGameSettings));
    }

    public void updateState() {
        snakeGameState.update();
    }
}
