package de.unikl.seda.snake.gui.snake.enums;

import de.unikl.seda.snake.gui.tools.GameObjectManager;

import static de.unikl.seda.snake.gui.tools.ResourceManager.*;

public enum Direction {
    LEFT {
        @Override
        public boolean goUp(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(UP);
            return true;
        }

        @Override
        public boolean goDown(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(DOWN);
            return true;
        }

        @Override
        public boolean goLeft(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public boolean goRight(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public void update(GameObjectManager gameObjectManager) {
            int currentX = gameObjectManager.getSnakeHead().getLocation().getX();
            currentX = currentX - 1;
            if (currentX < 0) {
                currentX = gameObjectManager.getxBound() - 1;
            }
            gameObjectManager.getSnakeHead().getLocation().setX(currentX);
        }

        @Override
        public int imageCode() {
            return SNAKE_HEAD_LEFT;
        }
    },

    RIGHT {
        @Override
        public boolean goUp(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(UP);
            return true;
        }

        @Override
        public boolean goDown(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(DOWN);
            return true;
        }

        @Override
        public boolean goLeft(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public boolean goRight(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public void update(GameObjectManager gameObjectManager) {
            int currentX = gameObjectManager.getSnakeHead().getLocation().getX();
            currentX = currentX + 1;
            if (currentX > gameObjectManager.getxBound() - 1) {
                currentX = 0;
            }
            gameObjectManager.getSnakeHead().getLocation().setX(currentX);
        }

        @Override
        public int imageCode() {
            return SNAKE_HEAD_RIGHT;
        }
    },

    UP {
        @Override
        public boolean goUp(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public boolean goDown(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public boolean goLeft(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(LEFT);
            return true;
        }

        @Override
        public boolean goRight(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(RIGHT);
            return true;
        }

        @Override
        public void update(GameObjectManager gameObjectManager) {
            int currentY = gameObjectManager.getSnakeHead().getLocation().getY();
            currentY = currentY - 1;
            if (currentY < 0) {
                currentY = gameObjectManager.getyBound() - 1;
            }
            gameObjectManager.getSnakeHead().getLocation().setY(currentY);
        }

        @Override
        public int imageCode() {
            return SNAKE_HEAD_UP;
        }
    },

    DOWN {
        @Override
        public boolean goUp(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public boolean goDown(GameObjectManager gameObjectManager) {
            return false;
        }

        @Override
        public boolean goLeft(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(LEFT);
            return true;
        }

        @Override
        public boolean goRight(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(RIGHT);
            return true;
        }

        @Override
        public void update(GameObjectManager gameObjectManager) {
            int currentY = gameObjectManager.getSnakeHead().getLocation().getY();
            currentY = currentY + 1;
            if (currentY > gameObjectManager.getyBound() - 1) {
                currentY = 0;
            }
            gameObjectManager.getSnakeHead().getLocation().setY(currentY);
        }

        @Override
        public int imageCode() {
            return SNAKE_HEAD_DOWN;
        }
    },

    IDLE {
        @Override
        public boolean goUp(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(UP);
            return true;
        }

        @Override
        public boolean goDown(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(DOWN);
            return true;
        }

        @Override
        // The snake facing right in the idle state
        public boolean goLeft(GameObjectManager gameObjectManager) {
            return true;
        }

        @Override
        public boolean goRight(GameObjectManager gameObjectManager) {
            gameObjectManager.getSnakeHead().setCurrentDirection(RIGHT);
            return true;
        }

        @Override
        public void update(GameObjectManager gameObjectManager) {

        }

        @Override
        public int imageCode() {
            return SNAKE_HEAD_RIGHT;
        }
    };

    public abstract boolean goUp(GameObjectManager gameObjectManager);
    public abstract boolean goDown(GameObjectManager gameObjectManager);
    public abstract boolean goLeft(GameObjectManager gameObjectManager);
    public abstract boolean goRight(GameObjectManager gameObjectManager);

    public abstract void update(GameObjectManager gameObjectManager);

    public abstract int imageCode();
}
