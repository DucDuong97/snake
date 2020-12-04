package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.model.GameObject;
import de.unikl.seda.snake.gui.snake.model.Point;
import de.unikl.seda.snake.gui.snake.model.SnakeHead;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;

import java.util.HashSet;
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

    enum  State {
        DEAD, ALIVE
    }

    //TODO implement level 2
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

    public void setScore(int score) {
        this.score = score;
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
    private void generateFood() {
        // generate a random Point
        // check if this point is available
        // add it to object list in gameState
    }

    //TODO collision detection 1.3
    private Hittable collision() {
        return null;
    }
}
