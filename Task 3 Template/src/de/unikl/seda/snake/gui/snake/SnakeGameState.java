package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.model.GameObject;
import de.unikl.seda.snake.gui.snake.model.Hittable;
import de.unikl.seda.snake.gui.snake.model.Point;

import java.util.List;

import java.awt.*;

import static de.unikl.seda.snake.gui.snake.SnakeGameState.Direction.*;
import static de.unikl.seda.snake.gui.snake.SnakeGameState.State.ALIVE;

public class SnakeGameState {
    // Game State
    private State state;

    // Snake
    private GameObject snakeHead;
    private Direction currentDirection;

    // In-game Objects
    private List<Hittable> objects;
    private int score;

    enum  State {
        DEAD, ALIVE
    }

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN,
        IDLE
    }

    //TODO implement level 2
    public SnakeGameState(SnakeGameSettings.GameLevel gameLevel) {
        this.state = ALIVE;
        this.currentDirection = IDLE;
        this.score = 0;
        // set init head location
        // create wall and add to objects list
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public GameObject getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(GameObject snakeHead) {
        this.snakeHead = snakeHead;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Hittable> getObjects() {
        return objects;
    }

    public void setObjects(List<Hittable> objects) {
        this.objects = objects;
    }
}
