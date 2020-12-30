package de.unikl.seda.snake.gui.snake.enums;

import de.unikl.seda.snake.gui.snake.gameobject.Point;
import de.unikl.seda.snake.gui.snake.gameobject.Wall;

import java.util.ArrayList;
import java.util.List;

public enum GameLevel {
    NO_BORDER {
        @Override
        public List<Wall> buildWall(int xBound, int yBound) {
            return new ArrayList<>();
        }

        @Override
        public int getConst() {
            return 0;
        }
    },

    VERTICAL_LINES {
        @Override
        public List<Wall> buildWall(int xBound, int yBound) {
            List<Wall> walls = new ArrayList<>();
            for (int i = (yBound / 5); i < (4 * yBound / 5) + 1; i++) {
                Wall rightWall = new Wall(new Point((2 * xBound / 3), i));
                walls.add(rightWall);
            }
            for (int i = (yBound / 5); i < (4 * yBound / 5) + 1; i++) {
                Wall leftWall = new Wall(new Point((xBound / 3), i));
                walls.add(leftWall);
            }
            return walls;
        }

        @Override
        public int getConst() {
            return 1;
        }
    },

    BOX {
        @Override
        public List<Wall> buildWall(int xBound, int yBound) {
            List<Wall> walls = new ArrayList<>();
            for (int i = 0; i < yBound; i++) {
                Wall rightWall = new Wall(new Point(xBound - 1, i));
                walls.add(rightWall);
            }
            for (int i = 0; i < xBound; i++) {
                Wall bottomWall = new Wall(new Point(i, yBound - 1));
                walls.add(bottomWall);
            }
            for (int i = 0; i < xBound; i++) {
                Wall topWall = new Wall(new Point(i, 0));
                walls.add(topWall);
            }
            for (int i = 0; i < yBound; i++) {
                Wall leftWall = new Wall(new Point(0, i));
                walls.add(leftWall);
            }
            return walls;
        }

        @Override
        public int getConst() {
            return 2;
        }
    };

    public abstract List<Wall> buildWall(int xBound, int yBound);
    public abstract int getConst();
}
