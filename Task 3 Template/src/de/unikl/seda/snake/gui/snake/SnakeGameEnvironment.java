package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.tools.GameEnvironment;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.Direction.*;

public class SnakeGameEnvironment extends GameEnvironment {

    private static final int GAME_INFO_BANNER_HEIGHT = 25;
    private static final int INFO_HEIGHT = 18;

    private Point currentLocation;
    private Direction currentDirection = IDLE;
    private Color currentColor;

    private String playerName;
    private int pixel;
    private int score;

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN,
        IDLE
    }

    public SnakeGameEnvironment(int width, int height, String playerName, int pixel) {
        // sets the size of the snake environment
        super(pixel *(width / pixel), pixel *(height / pixel) + GAME_INFO_BANNER_HEIGHT);
        this.playerName = playerName;
        this.pixel= pixel;
        this.score = 0;
        this.currentLocation = new Point(0, GAME_INFO_BANNER_HEIGHT);
        this.currentColor = Color.RED;

        System.out.println(getHeight());
    }

    @Override
    protected void handleKeypressUp() {
        currentDirection = UP;
        uiUpdateThread.interrupt();
        printMovementLog(currentLocation.getX(), currentLocation.getY(), currentDirection);
    }

    @Override
    protected void handleKeypressDown() {
        currentDirection = DOWN;
        uiUpdateThread.interrupt();
        printMovementLog(currentLocation.getX(), currentLocation.getY(), currentDirection);
    }

    @Override
    protected void handleKeypressLeft() {
        currentDirection = LEFT;
        uiUpdateThread.interrupt();
        printMovementLog(currentLocation.getX(), currentLocation.getY(), currentDirection);
    }

    @Override
    protected void handleKeypressRight() {
        currentDirection = RIGHT;
        uiUpdateThread.interrupt();
        printMovementLog(currentLocation.getX(), currentLocation.getY(), currentDirection);
    }

    @Override
    protected void handleReturnPress() {
        if (currentColor == Color.RED) {
            currentColor = Color.BLUE;
        } else {
            currentColor = Color.RED;
        }
        System.out.println("New color is " + currentColor.toString());
    }

    @Override
    protected void drawSnakeEnvironment(Graphics2D graphics) {
        // draw header
        graphics.setColor(new Color(125, 167, 116));
        graphics.fillRect(0,0,this.getWidth(), GAME_INFO_BANNER_HEIGHT);
        graphics.setColor(Color.BLACK);
        graphics.drawString(this.playerName, 10, INFO_HEIGHT);
        graphics.drawString("Score: " + this.score, getWidth() - 80, INFO_HEIGHT);

        // draw grid
        int y = GAME_INFO_BANNER_HEIGHT;
        while (y <= getHeight()) {
            int x = 0;
            while (x <= getWidth()) {
                graphics.drawRect(x, y, pixel, pixel);
                x += pixel;
            }
            y += pixel;
        }

        // draw snake
        graphics.setColor(currentColor);
        graphics.fillRect(currentLocation.getX(), currentLocation.getY(), this.pixel, this.pixel);
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

     public void moveForward() {
        int currentX = currentLocation.getX();
        int currentY = currentLocation.getY();
        switch(currentDirection) {
            case UP:

                currentY = currentY - pixel;
                if (currentY < GAME_INFO_BANNER_HEIGHT) {
                    currentY = getHeight() -pixel;
                }
                currentLocation.setY(currentY);
                break;
            case DOWN:
                currentY = currentY + pixel;
                if (currentY > getHeight() - pixel) {
                    currentY = GAME_INFO_BANNER_HEIGHT;
                }
                currentLocation.setY(currentY);
                break;
            case LEFT:
                currentX = currentX - pixel;
                if (currentX < 0) {
                    currentX = getWidth() - pixel;
                }
                currentLocation.setX(currentX);
                break;
            case RIGHT:
                currentX = currentX + pixel;
                if (currentX > getWidth() - pixel) {
                    currentX = 0;
                }
                currentLocation.setX(currentX);
                break;
            case IDLE:
                break;
        }
    }

    private void printMovementLog(int x, int y, Direction dir) {
        System.out.println("New location is (" + currentLocation.getX() + "," + currentLocation.getY()
                + ")\nNew Direction is " + currentDirection.toString());
    }
}
