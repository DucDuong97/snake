package de.unikl.seda.snake.gui.snake.enums;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.SnakeGameState;
import de.unikl.seda.snake.gui.menu.BackToMainMenuItem;
import de.unikl.seda.snake.gui.menu.GameMenu;
import de.unikl.seda.snake.gui.menu.ResumeMenuItem;

import java.awt.*;
import java.util.Arrays;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.INFO_HEIGHT;

public enum MainState {
    IN_MENU {
        @Override
        public void update(SnakeGameEnvironment snakeGameEnvironment) {

        }

        @Override
        public boolean handleKeypressUp(SnakeGameEnvironment snakeGameEnvironment) {
            snakeGameEnvironment.getGameMenu().up();
            return true;
        }

        @Override
        public boolean handleKeypressDown(SnakeGameEnvironment snakeGameEnvironment) {
            snakeGameEnvironment.getGameMenu().down();
            return true;
        }

        @Override
        public boolean handleKeypressLeft(SnakeGameEnvironment snakeGameEnvironment) {
            return snakeGameEnvironment.getGameMenu().left();
        }

        @Override
        public boolean handleKeypressRight(SnakeGameEnvironment snakeGameEnvironment) {
            return snakeGameEnvironment.getGameMenu().right();
        }

        @Override
        public boolean handleReturnPress(SnakeGameEnvironment snakeGameEnvironment) {
            return snakeGameEnvironment.getGameMenu().selectItem(snakeGameEnvironment);
        }

        @Override
        public boolean handleEscapePress(SnakeGameEnvironment snakeGameEnvironment) {
            return snakeGameEnvironment.getGameMenu().back(snakeGameEnvironment);
        }

        @Override
        public void draw(SnakeGameEnvironment snakeGameEnvironment, Graphics2D graphics) {
            snakeGameEnvironment.getGameMenu().draw(graphics, snakeGameEnvironment.getSnakeGameSettings());
        }

        @Override
        public void makeThreadSleep(SnakeGameEnvironment snakeGameEnvironment) throws InterruptedException {
            Thread.sleep(10000);
        }
    },
    IN_GAME {
        @Override
        public void update(SnakeGameEnvironment snakeGameEnvironment) {
            snakeGameEnvironment.getSnakeGameState().update();
        }

        @Override
        public boolean handleKeypressUp(SnakeGameEnvironment snakeGameEnvironment) {
            SnakeGameState gameState = snakeGameEnvironment.getSnakeGameState();
            return gameState.getSnakeHead().getCurrentDirection().goUp(gameState);
        }

        @Override
        public boolean handleKeypressDown(SnakeGameEnvironment snakeGameEnvironment) {
            SnakeGameState gameState = snakeGameEnvironment.getSnakeGameState();
            return gameState.getSnakeHead().getCurrentDirection().goDown(gameState);
        }

        @Override
        public boolean handleKeypressLeft(SnakeGameEnvironment snakeGameEnvironment) {
            SnakeGameState gameState = snakeGameEnvironment.getSnakeGameState();
            return gameState.getSnakeHead().getCurrentDirection().goLeft(gameState);
        }

        @Override
        public boolean handleKeypressRight(SnakeGameEnvironment snakeGameEnvironment) {
            SnakeGameState gameState = snakeGameEnvironment.getSnakeGameState();
            return gameState.getSnakeHead().getCurrentDirection().goRight(gameState);
        }

        @Override
        public boolean handleReturnPress(SnakeGameEnvironment snakeGameEnvironment) {
            return false;
        }

        @Override
        public boolean handleEscapePress(SnakeGameEnvironment snakeGameEnvironment) {
            snakeGameEnvironment.setGameMenu(new GameMenu(null
                    , Arrays.asList(new ResumeMenuItem(), new BackToMainMenuItem()), "pause"));
            snakeGameEnvironment.setMainState(IN_MENU);
            return true;
        }

        @Override
        public void draw(SnakeGameEnvironment snakeGameEnvironment, Graphics2D graphics) {
            graphics.drawString("Score: " + snakeGameEnvironment.getSnakeGameState().getScore(),
                    snakeGameEnvironment.getWidth() - 80, INFO_HEIGHT);
            snakeGameEnvironment.getSnakeGameState().getObjectSet()
                    .forEach(gameObject -> gameObject.draw(graphics, snakeGameEnvironment.getSnakeGameSettings()));
        }

        @Override
        public void makeThreadSleep(SnakeGameEnvironment snakeGameEnvironment) throws InterruptedException {
            Thread.sleep(snakeGameEnvironment.getGameSpeed());
        }
    };



    public abstract void update(SnakeGameEnvironment snakeGameEnvironment);

    public abstract boolean handleKeypressUp(SnakeGameEnvironment snakeGameEnvironment);
    public abstract boolean handleKeypressDown(SnakeGameEnvironment snakeGameEnvironment);
    public abstract boolean handleKeypressLeft(SnakeGameEnvironment snakeGameEnvironment);
    public abstract boolean handleKeypressRight(SnakeGameEnvironment snakeGameEnvironment);
    public abstract boolean handleReturnPress(SnakeGameEnvironment snakeGameEnvironment);
    public abstract boolean handleEscapePress(SnakeGameEnvironment snakeGameEnvironment);

    public abstract void draw(SnakeGameEnvironment snakeGameEnvironment, Graphics2D graphics);

    public abstract void makeThreadSleep(SnakeGameEnvironment snakeGameEnvironment) throws InterruptedException;
}
