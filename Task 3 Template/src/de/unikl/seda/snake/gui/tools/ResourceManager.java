package de.unikl.seda.snake.gui.tools;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    public static final String sound_prefix = "/de/unikl/seda/snake/gui/ressources/sounds/";
    public static final String image_prefix = "/de/unikl/seda/snake/gui/ressources/images/";

    // sound indices
    public static final int FOOD_EATEN = 0;
    public static final int GAME_OVER = 1;
    public static final int BACKGROUND = 2;

    // sound paths
    public static final String FOOD_EATEN_ITEM = sound_prefix + "snakehit.wav";
    public static final String GAME_OVER_ITEM = sound_prefix + "mixkitGameOver.wav";
    public static final String BACKGROUND_ITEM = sound_prefix + "KevinMacLeodMerryGoHQ.wav";

    // image indices
    public static final int SNAKE_HEAD_DOWN = 0;
    public static final int SNAKE_HEAD_RIGHT = 1;
    public static final int SNAKE_HEAD_UP = 2;
    public static final int SNAKE_HEAD_LEFT = 3;
    public static final int FOOD = 4;
    public static final int SNAKE_BODY = 5;

    // image paths
    public static final String SNAKE_HEAD_DOWN_ITEM = image_prefix + "snakeHeadD.png";
    public static final String SNAKE_HEAD_RIGHT_ITEM = image_prefix + "snakeHeadR.png";
    public static final String SNAKE_HEAD_UP_ITEM = image_prefix + "snakeHeadU.png";
    public static final String SNAKE_HEAD_LEFT_ITEM = image_prefix + "snakeHeadL.png";
    public static final String FOOD_ITEM = image_prefix + "food.png";
    public static final String SNAKE_BODY_ITEM = image_prefix + "snakeBody.png";


    private static Map<Integer, AudioInputStream> soundMap;
    private static Map<Integer, Image> imageMap;
    private static Clip backgroundSound;

    private static boolean isSoundEnable;

    static {
        soundMap =  new HashMap<>();
        imageMap =  new HashMap<>();

        try {
            //import sounds
            soundMap.put(FOOD_EATEN, createReusableAudioInputStream(FOOD_EATEN_ITEM));
            soundMap.put(GAME_OVER, createReusableAudioInputStream(GAME_OVER_ITEM));
            soundMap.put(BACKGROUND, createReusableAudioInputStream(BACKGROUND_ITEM));

            //import images
            imageMap.put(SNAKE_HEAD_DOWN, ImageIO.read(ResourceManager.class.getResourceAsStream(SNAKE_HEAD_DOWN_ITEM)));
            imageMap.put(SNAKE_HEAD_RIGHT, ImageIO.read(ResourceManager.class.getResourceAsStream(SNAKE_HEAD_RIGHT_ITEM)));
            imageMap.put(SNAKE_HEAD_UP, ImageIO.read(ResourceManager.class.getResourceAsStream(SNAKE_HEAD_UP_ITEM)));
            imageMap.put(SNAKE_HEAD_LEFT, ImageIO.read(ResourceManager.class.getResourceAsStream(SNAKE_HEAD_LEFT_ITEM)));
            imageMap.put(FOOD, ImageIO.read(ResourceManager.class.getResourceAsStream(FOOD_ITEM)));
            imageMap.put(SNAKE_BODY, ImageIO.read(ResourceManager.class.getResourceAsStream(SNAKE_BODY_ITEM)));
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    private static AudioInputStream createReusableAudioInputStream(String path)
            throws IOException, UnsupportedAudioFileException
    {
        try (InputStream inputStream = new BufferedInputStream(ResourceManager.class.getResourceAsStream(path));
             AudioInputStream ais = AudioSystem.getAudioInputStream(inputStream)) {
            byte[] buffer = new byte[1024 * 32];
            int read = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream(buffer.length);
            while ((read = ais.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, read);
            }
            return new AudioInputStream(
                            new ByteArrayInputStream(baos.toByteArray()),
                            ais.getFormat(),
                            AudioSystem.NOT_SPECIFIED);
        }
    }

    public static void playSound(int sound) {
        if (!isSoundEnable) {
            return;
        }
        try {
            AudioInputStream stream = soundMap.get(sound);
            stream.reset();
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void playBackgroundSound() {
        if (!isSoundEnable) {
            return;
        }
        try {
            AudioInputStream stream = ResourceManager.soundMap.get(ResourceManager.BACKGROUND);
            stream.reset();
            backgroundSound = AudioSystem.getClip();
            backgroundSound.open(stream);
            backgroundSound.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundSound.start();
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopBackgroundSound() {
        backgroundSound.stop();
    }

    public static Image getImage(int image) {
        return imageMap.get(image);
    }

    public static void setSoundEnable(boolean isSoundEnable) {
        ResourceManager.isSoundEnable = isSoundEnable;
    }
}
