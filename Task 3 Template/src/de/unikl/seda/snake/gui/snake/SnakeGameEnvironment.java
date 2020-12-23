package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.enums.MainState;
import de.unikl.seda.snake.gui.snake.menu.GameMenu;
import de.unikl.seda.snake.gui.tools.GameEnvironment;
import java.awt.*;

import static de.unikl.seda.snake.gui.snake.enums.MainState.*;
import static de.unikl.seda.snake.gui.snake.model.enums.Direction.*;

public class SnakeGameEnvironment extends GameEnvironment {

    public static final int GAME_INFO_BANNER_HEIGHT = 25;
    private static final int INFO_HEIGHT = 18;

    private SnakeGameState snakeGameState;
    private GameMenu gameMenu;
    private SnakeGameSettings snakeGameSettings;

    private MainState mainState;

    public SnakeGameEnvironment() {
        // sets the size of the snake environment
        super(0, 0, 0);
        this.snakeGameSettings = new SnakeGameSettings(this);
        this.snakeGameState = new SnakeGameState(snakeGameSettings);
        this.mainState = IN_MENU;

        SnakeGameSettingsAdjuster snakeGameSettingsAdjuster = new SnakeGameSettingsAdjuster(snakeGameSettings);
        this.gameMenu = GameMenu.createMainMenu(snakeGameSettingsAdjuster);
    }

    @Override
    protected void handleKeypressUp() {
        if (mainState.handleKeypressUp(this)) {
            uiUpdateThread.interrupt();
        }
    }

    @Override
    protected void handleKeypressDown() {
        if (mainState.handleKeypressDown(this)) {
            uiUpdateThread.interrupt();
        }
    }

    @Override
    protected void handleKeypressLeft() {
        if (mainState.handleKeypressLeft(this)) {
            uiUpdateThread.interrupt();
        }
    }

    @Override
    protected void handleKeypressRight() {
        if (mainState.handleKeypressRight(this)) {
            uiUpdateThread.interrupt();
        }
    }

    @Override
    protected void handleReturnPress() {
        if (mainState.handleReturnPress(this)) {
            uiUpdateThread.interrupt();
        }
    }

    @Override
    protected void handleEscapePress() {
        if (mainState.handleEscapePress(this)) {
            uiUpdateThread.interrupt();
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
//        int y = GAME_INFO_BANNER_HEIGHT;
//        while (y <= getHeight()) {
//            int x = 0;
//            while (x <= getWidth()) {
//                graphics.drawRect(x, y, snakeGameSettings.getSquareSize(), snakeGameSettings.getSquareSize());
//                x += snakeGameSettings.getSquareSize();
//            }
//            y += snakeGameSettings.getSquareSize();
//        }

        // draw Objects
        mainState.draw(this, graphics);
    }

    public void makeThreadSleep() throws InterruptedException {
        mainState.makeThreadSleep(this);
    }

    public void updateState() {
        mainState.update(this);
    }

    public SnakeGameSettings getSnakeGameSettings() {
        return snakeGameSettings;
    }

    public SnakeGameState getSnakeGameState() {
        return snakeGameState;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public void setMainState(MainState mainState) {
        this.mainState = mainState;
    }
}
