package de.unikl.seda.snake.gui.tools;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.snake.gameobject.*;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.GameObject;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Hittable;
import de.unikl.seda.snake.gui.snake.gameobject.interfaces.Updatable;
import java.util.*;

import static de.unikl.seda.snake.gui.snake.enums.Direction.IDLE;

public class GameObjectManager {
    private boolean poopMode;
    private int life;
    // Static properties
    private int xBound;
    private int yBound;
    // Game State
    private int score;
    private boolean poop = false;
    // In-game Objects
    private Set<GameObject> objectSet;
    private Set<Updatable> updatableSet;
    private Map<Point, Hittable> hittableMap;
    private Queue<Runnable> updateQueue;
    private boolean updating = false;
    // Snake
    private SnakeHead snakeHead;
    private ArrayList<SnakeBody> snakeBody;
    private SnakeGameEnvironment snakeGameEnvironment;

    public GameObjectManager(SnakeGameEnvironment snakeGameEnvironment) {
        ResourceManager.playBackgroundSound();
        this.snakeGameEnvironment = snakeGameEnvironment;
        this.xBound = snakeGameEnvironment.getSnakeGameSettings().getxBound();
        this.yBound = snakeGameEnvironment.getSnakeGameSettings().getyBound();
        this.poopMode = snakeGameEnvironment.getSnakeGameSettings().isPoopMode();
        if (poopMode) {
            this.life = 3;
        }

        System.out.println("Setting up the game");
        this.score = 0;
        this.objectSet = new HashSet<>();
        this.updatableSet = new TreeSet<>();
        this.hittableMap = new HashMap<>();
        this.updateQueue = new LinkedList<>();
        buildWall();
        createSnake();
        for (int i = 0; i < snakeGameEnvironment.getSnakeGameSettings().getNumOfFoods(); i++) {
            addObject(new Food(generateRandomPoint()));
        }
    }

    private void buildWall() {
        snakeGameEnvironment.getSnakeGameSettings()
                .getGameLevel()
                .buildWall(xBound, yBound)
                .forEach(this::addObject);
    }

    private void createSnake() {
        this.snakeHead = new SnakeHead(new Point(2,1));
        SnakeBody firstSnakeBody = new SnakeBody(new Point(1,1));
        addObject(snakeHead);
        snakeBody = new ArrayList<>();
        this.snakeBody.add(firstSnakeBody);
        addObject(firstSnakeBody);
    }

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }

    public int getScore() {
        return score;
    }

    public int getLife() {
        return life;
    }

    public void decreaseLife() {
        this.life--;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public Set<GameObject> getObjectSet() {
        return new HashSet<>(this.objectSet);
    }

    public void dead() {
        ResourceManager.playSound(ResourceManager.GAME_OVER);
        ResourceManager.stopBackgroundSound();
        snakeGameEnvironment.goToGameOverMenu(score);
    }

    public void update() {
        updating = true;
        this.updatableSet.forEach(updatable -> updatable.update(this));
        while (!updateQueue.isEmpty()) updateQueue.poll().run();
        Hittable hittable = hittableMap.get(snakeHead.getLocation());
        if (!(hittable instanceof Food) && snakeHead.getCurrentDirection() != IDLE) {
            Point poopLocation = snakeBody.get(0).getLocation();
            removeObject(snakeBody.remove(0));
            if (poop) {
                addObject(new Poop(poopLocation));
                poop = !poop;
            }
        }
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
            x = rand.nextInt(xBound);
            //Generate a y-coordinate between [GAME_INFO_BANNER_HEIGHT, getHeight() - pixel]
            y = rand.nextInt(yBound);
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
//        System.out.println("Generate point at " + tempPoint.getX() + " " + tempPoint.getY());
        return tempPoint;

    }

    public void addObject(GameObject object) {
        if (updating) {
            this.updateQueue.add(()-> {
                this.objectSet.add(object);
                if (object instanceof Updatable) {
                    //System.out.println("Added Updatable");
                    updatableSet.add((Updatable)object);
                }
                if (object instanceof Hittable) {
                    System.out.println("Added Hittable");
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

    public ArrayList<SnakeBody> getSnakeBody() {
        return snakeBody;
    }

    public int getxBound() {
        return xBound;
    }

    public int getyBound() {
        return yBound;
    }

    public boolean isPoopMode() {
        return poopMode;
    }

    public void setPoop(boolean poopMode) {
        this.poop = poopMode;
    }
}
