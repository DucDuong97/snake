package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.tools.GameEnvironment;

import java.awt.*;

public class SnakeGameEnvironment extends GameEnvironment {

    private final int HEADER_HEIGHT = 40;
    private final int INFO_HEIGHT = 25;
    private static final int gameInfoBannerHeight = 25;
    //TODO implement point 3

    private String playerName;
    private int pixel;
    private int score;


    public SnakeGameEnvironment(int width, int height, String playerName, int pixel) {
        // sets the size of the snake environment
        super(width, height + gameInfoBannerHeight);
        this.playerName = playerName;
        this.pixel= pixel;
        this.score = 0;
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

        //TODO design GUI 2

        // draw header
        graphics.setColor(new Color(125, 167, 116));
        graphics.fillRect(0,0,this.getWidth(),HEADER_HEIGHT);
        graphics.setColor(Color.BLACK);
        graphics.drawString(this.playerName, 10, INFO_HEIGHT);
        graphics.drawString("Score: " + this.score, getWidth() - 80, INFO_HEIGHT);

        // draw grid
        int y = HEADER_HEIGHT;
        while (y < getHeight()) {
            int x = 0;
            while (x < getWidth()) {
                graphics.drawRect(x, y, pixel, pixel);
                x += pixel;
            }
            y += pixel;
        }

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
}
