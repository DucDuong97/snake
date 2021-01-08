package de.unikl.seda.snake.gui.menu;

import de.unikl.seda.snake.gui.snake.SnakeGameEnvironment;
import de.unikl.seda.snake.gui.tools.SnakeGameSettings;
import de.unikl.seda.snake.gui.tools.SnakeGameSettingsAdjuster;
import de.unikl.seda.snake.gui.snake.interfaces.Drawable;
import de.unikl.seda.snake.gui.menu.interfaces.Adjustable;
import de.unikl.seda.snake.gui.menu.interfaces.MenuItem;
import de.unikl.seda.snake.gui.menu.interfaces.Selectable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static de.unikl.seda.snake.gui.snake.SnakeGameEnvironment.GAME_INFO_BANNER_HEIGHT;

public class GameMenu implements Drawable, Selectable {
    private final static int FONT_SIZE = 20;

    private String name;
    private GameMenu parentGameMenu;
    private List<MenuItem> childItem;
    private int position;

    public GameMenu(GameMenu parentGameMenu, List<MenuItem> childItem, String name) {
        this.parentGameMenu = parentGameMenu;
        this.childItem = childItem;
        this.name = name;
        this.position = 0;
    }

    @Override
    public void draw(Graphics2D graphics, SnakeGameSettings gameSettings) {
        final int cellHeight = FONT_SIZE + 10;
        FontMetrics fontMetrics = graphics.getFontMetrics();

        //highlight current position
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, GAME_INFO_BANNER_HEIGHT + cellHeight*position, gameSettings.getWidth(), cellHeight);

        //draw cell
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));
        int yText = GAME_INFO_BANNER_HEIGHT - 6;
        for (MenuItem item : childItem) {
            int xText = 10;
            yText += cellHeight;
            graphics.drawString(item.getName(), xText, yText);
            if (item instanceof Adjustable) {
                String text = "- " + ((Adjustable)item).getValue() + " +";
                xText = gameSettings.getWidth() - fontMetrics.stringWidth(text) * 2;
                graphics.drawString(text, xText, yText);
            }
        }
    }

    public boolean selectItem(SnakeGameEnvironment snakeGameEnvironment) {
        if (childItem.get(position) instanceof Selectable) {
            ((Selectable) childItem.get(position)).selected(snakeGameEnvironment);
            return true;
        }
        return false;
    }

    @Override
    public void selected(SnakeGameEnvironment snakeGameEnvironment) {
        snakeGameEnvironment.setGameMenu(this);
    }

    public boolean back(SnakeGameEnvironment snakeGameEnvironment) {
        if (parentGameMenu == null) {
            return false;
        }
        snakeGameEnvironment.setGameMenu(parentGameMenu);
        return true;
    }

    public void up() {
        if (position == 0) {
            position = childItem.size() - 1;
        } else {
            position--;
        }
    }

    public void down() {
        if (position == childItem.size() - 1) {
            position = 0;
        } else {
            position++;
        }
    }

    public boolean left() {
        MenuItem item = this.childItem.get(position);
        if (item instanceof Adjustable) {
            ((Adjustable) item).decrease();
            return true;
        }
        return false;
    }

    public boolean right() {
        MenuItem item = this.childItem.get(position);
        if (item instanceof Adjustable) {
            ((Adjustable) item).increase();
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    private void setParentGameMenu(GameMenu gameMenu) {
        this.parentGameMenu = gameMenu;
    }

    public static GameMenu createMainMenu(SnakeGameSettingsAdjuster snakeGameSettingsAdjuster) {
        GameMenu gameMenuSettings = new GameMenu(null,
                Arrays.asList(
                        new ResolutionMenuItem(snakeGameSettingsAdjuster),
                        new SpeedMenuItem(snakeGameSettingsAdjuster),
                        new LevelMenuItem(snakeGameSettingsAdjuster),
                        new PlayerNameMenuItem(),
                        new SoundMenuItem(snakeGameSettingsAdjuster)),
                "Settings");
        GameMenu gameMenuRoot = new GameMenu(null,
                Arrays.asList(
                        new PlayMenuItem(),
                        gameMenuSettings,
                        new AboutMenuItem(),
                        new QuitMenuItem()),
                "root");
        gameMenuSettings.setParentGameMenu(gameMenuRoot);
        return gameMenuRoot;
    }
}
