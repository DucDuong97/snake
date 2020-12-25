package de.unikl.seda.snake.gui.snake.model.enums;

import de.unikl.seda.snake.gui.snake.SnakeGameState;

public enum Direction {
    LEFT {
        @Override
        public boolean goUp(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(UP);
            return true;
        }

        @Override
        public boolean goDown(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(DOWN);
            return true;
        }

        @Override
        public boolean goLeft(SnakeGameState snakeGameState) {
            return false;
        }

        @Override
        public boolean goRight(SnakeGameState snakeGameState) {
            return false;
        }
    },

    RIGHT {
        @Override
        public boolean goUp(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(UP);
            return true;
        }

        @Override
        public boolean goDown(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(DOWN);
            return true;
        }

        @Override
        public boolean goLeft(SnakeGameState snakeGameState) {
            return false;
        }

        @Override
        public boolean goRight(SnakeGameState snakeGameState) {
            return false;
        }
    },

    UP {
        @Override
        public boolean goUp(SnakeGameState snakeGameState) {
            return false;
        }

        @Override
        public boolean goDown(SnakeGameState snakeGameState) {
            return false;
        }

        @Override
        public boolean goLeft(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(LEFT);
            return true;
        }

        @Override
        public boolean goRight(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(RIGHT);
            return true;
        }
    },

    DOWN {
        @Override
        public boolean goUp(SnakeGameState snakeGameState) {
            return false;
        }

        @Override
        public boolean goDown(SnakeGameState snakeGameState) {
            return false;
        }

        @Override
        public boolean goLeft(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(LEFT);
            return true;
        }

        @Override
        public boolean goRight(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(RIGHT);
            return true;
        }
    },

    IDLE {
        @Override
        public boolean goUp(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(UP);
            return true;
        }

        @Override
        public boolean goDown(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(DOWN);
            return true;
        }

        @Override
        // The snake facing right in the idle state
        public boolean goLeft(SnakeGameState snakeGameState) {
            return true;
        }

        @Override
        public boolean goRight(SnakeGameState snakeGameState) {
            snakeGameState.getSnakeHead().setCurrentDirection(RIGHT);
            return true;
        }
    };

    public abstract boolean goUp(SnakeGameState snakeGameState);
    public abstract boolean goDown(SnakeGameState snakeGameState);
    public abstract boolean goLeft(SnakeGameState snakeGameState);
    public abstract boolean goRight(SnakeGameState snakeGameState);
}
