package fr.evite.utils;

import fr.evite.Evite;

import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

public class SoundManager {

    public static Clip ButtonHover;

    public static Clip CurrentSong;

    public static ArrayList<Clip> pause = new ArrayList<>();

    public static long MicroLength;

    public static void pause(Clip clip){
        clip.stop();
    }

    public static void replay(Clip clip){
        clip.start();
    }

    public static void playHoverButton(){
        File f = new File(Evite.ResourcePath + "sounds/buttonhover/ButtonHover.wav");
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            ButtonHover = AudioSystem.getClip();
            ButtonHover.open(ais);
            ButtonHover.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static void play(String sound){
        File f = new File(Evite.ResourcePath + "sounds/" + sound + ".wav");
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            ButtonHover = AudioSystem.getClip();
            ButtonHover.open(ais);
            ButtonHover.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static void playRandomSong(){
        InputStream is;
        BufferedReader buf = null;
        List<String> songList = null;
        try {
            is = new FileInputStream("src/fr/evite/song.yml");
            buf = new BufferedReader(new InputStreamReader(is));
            songList = new ArrayList<String>(Arrays.asList(buf.readLine().split(", "))) ;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();

        File f = new File("src/fr/evite/resources/sounds/song/" + songList.get(random.nextInt(songList.size())) + ".wav");
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            CurrentSong = AudioSystem.getClip();
            CurrentSong.open(ais);
            CurrentSong.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static Clip getCurrentSong(){ return CurrentSong; }

}
