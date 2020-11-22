package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.tools.GameEnvironment;

import java.awt.*;

public class SnakeGameEnvironment extends GameEnvironment {
    // implement currentLocation
    private Point currentLocation;
    private static final int gameInfoBannerHeight = 25;
    private int count = 0;
    private String playerName;
    private int pixel;

    public SnakeGameEnvironment(int height, int width, String playerName, int pixel) {
        // sets the size of the snake environment
        super(height, width + gameInfoBannerHeight);
        this.playerName = playerName;
        this.pixel= pixel;
        this.currentLocation = new Point(0, 40);
    }

    //TODO implement input logic 4

    @Override
    protected void handleKeypressUp() {
        System.out.println("Up");
    }

    @Override
    protected void handleKeypressDown() {
        System.out.println("Down");
    }

    @Override
    protected void handleKeypressLeft() {
        System.out.println("Left");
    }

    @Override
    protected void handleKeypressRight() {
        System.out.println("Right");
    }

    @Override
    protected void handleReturnPress() {
        System.out.println("RETURN");
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

        graphics.setColor(Color.ORANGE);
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
}
