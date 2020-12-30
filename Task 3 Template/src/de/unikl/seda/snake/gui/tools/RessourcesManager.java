package de.unikl.seda.snake.gui.tools;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RessourcesManager {

    public static final String sound_prefix = "src/de/unikl/seda/snake/gui/ressources/sounds/";
    public static final String image_prefix = "src/de/unikl/seda/snake/gui/ressources/images/";

    // sound indices
    public static final int FOOD_EATEN = 0;

    // sound paths
    public static final String FOOD_EATEN_ITEM = sound_prefix + "snakehit.wav";

    // image indices
    public static final int SNAKE_HEAD_DOWN = 0;
    public static final int SNAKE_HEAD_RIGHT = 1;

    // image paths
    public static final String SNAKE_HEAD_DOWN_ITEM = image_prefix + "snakeHead.jpg";
    public static final String SNAKE_HEAD_RIGHT_ITEM = image_prefix + "snakehHeadR.png";

    private static Map<Integer, AudioInputStream> soundMap;
    private static Map<Integer, Image> imageMap;

    static {
        soundMap =  new HashMap<>();
        imageMap =  new HashMap<>();

        try {
            //import sounds
            soundMap.put(FOOD_EATEN, createReusableAudioInputStream(FOOD_EATEN_ITEM));

            //import images
            imageMap.put(SNAKE_HEAD_DOWN, ImageIO.read(new File(SNAKE_HEAD_DOWN_ITEM)));
            imageMap.put(SNAKE_HEAD_RIGHT, ImageIO.read(new File(SNAKE_HEAD_RIGHT_ITEM)));
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    private static AudioInputStream createReusableAudioInputStream(String path)
            throws IOException, UnsupportedAudioFileException
    {
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path))) {
            byte[] buffer = new byte[1024 * 32];
            int read = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream(buffer.length);
            while ((read = ais.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, read);
            }
            AudioInputStream reusableAis = new AudioInputStream(
                            new ByteArrayInputStream(baos.toByteArray()),
                            ais.getFormat(),
                            AudioSystem.NOT_SPECIFIED);
            return reusableAis;
        }
    }

    public static void playSound(int sound) {
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

    public static Image getImage(int image) {
        return imageMap.get(image);
    }
}
