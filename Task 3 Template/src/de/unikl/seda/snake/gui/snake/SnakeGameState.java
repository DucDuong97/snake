package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.model.*;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;
import static de.unikl.seda.snake.gui.snake.SnakeGameSettings.GameLevel.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static de.unikl.seda.snake.gui.snake.SnakeGameState.State.ALIVE;
import static de.unikl.seda.snake.gui.snake.SnakeGameState.State.DEAD;

public class SnakeGameState {
    // Game State
    private State state;
    private SnakeGameSettings gameSettings;
    private int score;

    // In-game Objects
    private Set<GameObject> objectSet;
    private Set<Updatable> updatableSet;
    private Set<Hittable> hittableSet;

    // Snake
    private SnakeHead snakeHead;

    public enum  State {
        DEAD, ALIVE
    }


    public SnakeGameState(SnakeGameSettings gameSettings) {
        this.state = ALIVE;
        this.gameSettings = gameSettings;
        this.score = 0;

        this.objectSet = new HashSet<>();
        this.updatableSet = new HashSet<>();
        this.hittableSet = new HashSet<>();

        this.snakeHead = new SnakeHead(new Point(0, 0));
        this.objectSet.add(snakeHead);
        this.updatableSet.add(snakeHead);

        // implement level 2 and 3

        System.out.println("value of x is:" + gameSettings.getxBound());
        System.out.println("value of y is:" + gameSettings.getyBound());
        System.out.println("value of level is:" + gameSettings.getGameLevel());

        if(gameSettings.getGameLevel() == VERTICAL_LINES) {

            for (int i = (gameSettings.getyBound() / 5); i < (4 * gameSettings.getyBound() / 5) + 1; i++) {
                System.out.println("rightWall-level3 created");
                Wall rightWall = new Wall(new Point((2 * gameSettings.getxBound() / 3), i));
                this.objectSet.add(rightWall);
                this.hittableSet.add(rightWall);
            }

            for (int i = (gameSettings.getyBound() / 5); i < (4 * gameSettings.getyBound() / 5) + 1; i++) {
                System.out.println("leftWall-level3 created");
                Wall leftWall = new Wall(new Point((gameSettings.getxBound() / 3), i));
                this.objectSet.add(leftWall);
                this.hittableSet.add(leftWall);
            }
        }else if (gameSettings.getGameLevel() == BOX){

            for (int i = 0; i < gameSettings.getyBound(); i++) {
                System.out.println("rightWall created");
                Wall rightWall = new Wall(new Point(gameSettings.getxBound() - 1, i));
                this.objectSet.add(rightWall);
                this.hittableSet.add(rightWall);
            }

            for (int i = 0; i < gameSettings.getxBound(); i++) {
                System.out.print("bottomWall created");
                Wall bottomWall = new Wall(new Point(i, gameSettings.getyBound() - 1));
                this.objectSet.add(bottomWall);
                this.hittableSet.add(bottomWall);
            }

            for (int i = 0; i < gameSettings.getxBound(); i++) {
                System.out.println("topWall created");
                Wall topWall = new Wall(new Point(i, 0));
                this.objectSet.add(topWall);
                this.hittableSet.add(topWall);
            }

            for (int i = 0; i < gameSettings.getyBound(); i++) {
                System.out.println("leftWall created");
                Wall leftWall = new Wall(new Point(0, i));
                this.objectSet.add(leftWall);
                this.hittableSet.add(leftWall);
            }
        }


        generateFood();
        // set init head location
        // create wall and add to objects list

    }

    public SnakeGameSettings getGameSettings() {
        return gameSettings;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(SnakeHead snakeHead) {
        this.snakeHead = snakeHead;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public Set<Updatable> getUpdatableSet() {
        return updatableSet;
    }

    public Set<Hittable> getHittableSet() {
        return hittableSet;
    }

    public Set<GameObject> getObjectSet() {
        return objectSet;
    }

    public void update() {

        // game over
        if (this.state == DEAD) {
            return;
        }
        this.updatableSet.forEach(updatable -> updatable.update(this));
        Hittable hittable = collision();
        if (hittable != null) {
            hittable.hitted(this);
        }
    }

    //TODO food placement 1.2
    public void generateFood() {
        // generate a random Point
        Random rand = new Random();

        boolean overlap = false;
        int x;
        int y;

        Point tempPoint;
        do {
            //Generate a x-coordinate between [0, getWidth()], the value must divisible by pixel
            x = rand.nextInt(gameSettings.getxBound());
            //Generate a y-coordinate between [GAME_INFO_BANNER_HEIGHT, getHeight() - pixel]
            y = rand.nextInt(gameSettings.getyBound());
            tempPoint = new Point(x, y);
            //Make sure the generated coordinate not overlap with the snake or wall if so spawn the food and reset the counter
            for (GameObject g : objectSet) {
                if (g.getLocation().equals(tempPoint)) {
                    overlap = true;
                    break;
                }
            }
        } while (overlap);

        // Update the sets
        Food newFood = new Food(tempPoint);
        hittableSet.add(newFood);
        objectSet.add(newFood);
        updatableSet.add(newFood);
    }

    private Hittable collision() {
        // Check if the snake hit something
        for (Hittable h : hittableSet) {
            if (snakeHead.getLocation().equals(h.getLocation())) {return h;}
        }
        return null;
    }
}
