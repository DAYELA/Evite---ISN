package fr.evite.utils;

import fr.evite.Evite;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MapManager {

    private static String rMap;

    public static String selectRandomMap(){
        InputStream is;
        BufferedReader buf = null;
        List<String> mapList = null;
        try {
            is = new FileInputStream("src/fr/evite/maps.yml");
            buf = new BufferedReader(new InputStreamReader(is));
            mapList = new ArrayList<String>(Arrays.asList(buf.readLine().split(", "))) ;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();

        rMap = mapList.get(random.nextInt(mapList.size()));

        return  Evite.ResourcePath + "textures/maps/"  + rMap + ".gif";
    }

    public static String getActualMap(){ return rMap; }

}
