package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.tools.GameEnvironment;

import java.awt.*;

public class SnakeGameEnvironment extends GameEnvironment {
    // implement currentLocation
    private Point currentLocation;
    private Direction currentDirection = Direction.IDLE;
    private Color currentColor;
    private static final int gameInfoBannerHeight = 25;
    private int count = 0;
    private String playerName;
    private int pixel;

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN,
        IDLE
    }

    public SnakeGameEnvironment(int height, int width, String playerName, int pixel) {
        // sets the size of the snake environment
        super(height, width + gameInfoBannerHeight);
        this.playerName = playerName;
        this.pixel= pixel;
        this.currentLocation = new Point(0, 40);
        this.currentColor = Color.RED;
    }

    @Override
    protected void handleKeypressUp() {
        currentDirection = Direction.UP;
        int currentY = currentLocation.getY();
        currentY = currentY - pixel;
        if (currentY < 40) {
            currentY = getHeight() - gameInfoBannerHeight;
        }
        currentLocation.setY(currentY);
        printMovementLog(currentLocation.getX(), currentLocation.getY(), currentDirection);
    }

    @Override
    protected void handleKeypressDown() {
        currentDirection = Direction.DOWN;
        int currentY = currentLocation.getY();
        currentY = currentY + pixel;
        if (currentY > getHeight() - gameInfoBannerHeight) {
            currentY = pixel;
        }
        currentLocation.setY(currentY);
        printMovementLog(currentLocation.getX(), currentLocation.getY(), currentDirection);
    }

    @Override
    protected void handleKeypressLeft() {
        currentDirection = Direction.LEFT;
        int currentX = currentLocation.getX();
        currentX = currentX - pixel;
        if (currentX < 0) {
            currentX = getWidth() - pixel;
        }
        currentLocation.setX(currentX);
        printMovementLog(currentLocation.getX(), currentLocation.getY(), currentDirection);
    }

    @Override
    protected void handleKeypressRight() {
        currentDirection = Direction.RIGHT;
        int currentX = currentLocation.getX();
        currentX = currentX + pixel;
        if (currentX > getWidth() - pixel) {
            currentX = 0;
        }
        currentLocation.setX(currentX);
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

        //design GUI 2

        graphics.setColor(new Color(125, 167, 116));
        graphics.fillRect(0,0,this.getWidth(),40);
        graphics.setColor(Color.BLACK);
        graphics.drawString(this.playerName, 10, 20);

        int y = 40;
        while (y < getHeight()) {
            int x = 0;
            while (x < getWidth()) {
                graphics.drawRect(x, y, pixel, pixel);
                x += pixel;
            }
            y += pixel;
        }

        graphics.setColor(currentColor);
        graphics.fillRect(currentLocation.getX(), currentLocation.getY(), this.pixel, this.pixel);

//        graphics.drawString("Hello Snake!", 100, 400);
//        graphics.drawString("Width: " + getWidth() + " Height: " + getHeight(), 100, 430);
//        graphics.drawString("Counter: " + count++, 100, 460);
//
//        graphics.setColor(new Color(212, 212, 212));
//        graphics.drawRect(10, 15, 90, 60);
//        graphics.drawRect(130, 15, 90, 60);
//        graphics.drawRect(250, 15, 90, 60);
//        graphics.drawRect(10, 105, 90, 60);
//        graphics.drawRect(130, 105, 90, 60);
//        graphics.drawRect(250, 105, 90, 60);
//        graphics.drawRect(10, 195, 90, 60);
//        graphics.drawRect(130, 195, 90, 60);
//        graphics.drawRect(250, 195, 90, 60);
//
//        graphics.setColor(new Color(125, 167, 116));
//        graphics.fillRect(10, 15, 90, 60);
//
//        graphics.setColor(new Color(42, 179, 231));
//        graphics.fillRect(130, 15, 90, 60);
//
//        graphics.setColor(new Color(70, 67, 123));
//        graphics.fillRect(250, 15, 90, 60);
//
//        graphics.setColor(new Color(130, 100, 84));
//        graphics.fillRect(10, 105, 90, 60);
//
//        graphics.setColor(new Color(252, 211, 61));
//        graphics.fillRect(130, 105, 90, 60);
//
//        graphics.setColor(new Color(241, 98, 69));
//        graphics.fillRect(250, 105, 90, 60);
//
//        graphics.setColor(new Color(217, 146, 54));
//        graphics.fillRect(10, 195, 90, 60);
//
//        graphics.setColor(new Color(63, 121, 186));
//        graphics.fillRect(130, 195, 90, 60);
//
//        graphics.setColor(new Color(31, 21, 1));
//        graphics.fillRect(250, 195, 90, 60);
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

    private void printMovementLog(int x, int y, Direction dir) {
        System.out.println("New location is (" + currentLocation.getX() + "," + currentLocation.getY()
                + ")\nNew Direction is " + currentDirection.toString());
    }
}
