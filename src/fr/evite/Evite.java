package fr.evite;


import javax.swing.*;
import java.awt.*;

public class Evite {

    public static String ResourcePath = "src/fr/evite/resources/";

    private static Evite instance;

    static JButton b, b1, b2;

    // label to diaplay text
    static JLabel l;

    public static JPanel mainMenu;
    public static JPanel game;
    public static JFrame fenetre;

    public Evite(){
        instance = this;

    }


    public static void main(String[] args)
    {
        fenetre = new JFrame();
        mainMenu = new MainMenu();

        fenetre.setTitle("Évite - ISN");
        fenetre.setSize(1080, 720);
        fenetre.setContentPane(new MainMenu());
        fenetre.setUndecorated(true);
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fenetre.repaint();
        fenetre.revalidate();

    }
}
