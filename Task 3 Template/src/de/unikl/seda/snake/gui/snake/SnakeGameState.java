package de.unikl.seda.snake.gui.snake;

import de.unikl.seda.snake.gui.snake.model.*;
import de.unikl.seda.snake.gui.snake.model.interfaces.GameObject;
import de.unikl.seda.snake.gui.snake.model.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.model.interfaces.Updatable;

import java.util.*;

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
    private Map<Point, Hittable> hittableMap;
    private Queue<Runnable> updateQueue;
    private boolean updating = false;
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
        this.updatableSet = new TreeSet<>();
        this.hittableMap = new HashMap<>();
        this.updateQueue = new LinkedList<>();

        gameSettings.getGameLevel().buildWall(gameSettings.getxBound(), gameSettings.getyBound())
            .forEach(this::addObject);

        this.snakeHead = new SnakeHead(generateRandomPoint());
        addObject(snakeHead);
        addObject(new Food(generateRandomPoint()));
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

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public Set<GameObject> getObjectSet() {
        return new HashSet<>(this.objectSet);
    }

    public void update() {
        // game over
        if (this.state == DEAD) {
            return;
        }
        updating = true;
        this.updatableSet.forEach(updatable -> updatable.update(this));
        while (!updateQueue.isEmpty()) updateQueue.poll().run();
        Hittable hittable = hittableMap.get(snakeHead.getLocation());
        if (hittable != null) { hittable.whenHitting(this); }
        while (!updateQueue.isEmpty()) updateQueue.poll().run();
        updating = false;
    }

    public Point generateRandomPoint() {
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
        return tempPoint;
    }

    public void addObject(GameObject object) {
        if (updating) {
            this.updateQueue.add(()-> {
                this.objectSet.add(object);
                if (object instanceof Updatable) {
                    updatableSet.add((Updatable)object);
                }
                if (object instanceof Hittable) {
                    hittableMap.put(object.getLocation(), (Hittable)object);
                }
            });
        } else {
            this.objectSet.add(object);
            if (object instanceof Updatable) {
                updatableSet.add((Updatable)object);
            }
            if (object instanceof Hittable) {
                hittableMap.put(object.getLocation(), (Hittable)object);
            }
        }
    }

    public void removeObject(GameObject object) {
        if (updating) {
            this.updateQueue.add(()-> {
                this.objectSet.remove(object);
                if (object instanceof Updatable) {
                    updatableSet.remove(object);
                }
                if (object instanceof Hittable) {
                    hittableMap.remove(object.getLocation());
                }
            });
        } else {
            this.objectSet.remove(object);
            if (object instanceof Updatable) {
                updatableSet.remove(object);
            }
            if (object instanceof Hittable) {
                hittableMap.remove(object.getLocation());
            }
        }
    }
}
