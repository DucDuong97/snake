package de.unikl.seda.snake.gui.tools;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RessourcesManager {

    public static final String sound_prefix = "src/de/unikl/seda/snake/gui/ressources/sounds/";
    public static final String image_prefix = "src/de/unikl/seda/snake/gui/ressources/images/";

    public static final int FOOD_EATEN = 0;

    public static final String FOOD_EATEN_ITEM = "D:\\Working Bench\\Active Duties\\FSE\\se-project-2020-3\\Task 3 Template\\src\\de\\unikl\\seda\\snake\\gui\\ressources\\sounds\\snakehit.wav";
    private static Map<Integer, AudioInputStream> soundMap;

    static {
        soundMap =  new HashMap<>();

        try {
            soundMap.put(FOOD_EATEN, createReusableAudioInputStream(FOOD_EATEN_ITEM));
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
}
