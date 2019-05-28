package fr.evite;

import fr.evite.game.Game;
import fr.evite.utils.CustomButton;
import fr.evite.utils.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel
{

    public static CustomButton facile;
    public static CustomButton difficile;


    private Image background;

    private static MainMenu instance;

    public MainMenu()
    {
        instance = this;
        this.setLayout(null);

        /**
         *
         *  On crée un boutton jouer et on lui applique un event pour qu'il réagisse quand
         *
         */

        CustomButton jouer = new CustomButton("", Evite.ResourcePath + "textures/buttons/Jouer.png", Evite.ResourcePath + "textures/buttons/JouerH.png");
        jouer.setBounds(127, 334, 191, 66);
        jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoundManager.play("PlayButton");

                Evite.fenetre.setVisible(false);

                Evite.fenetre = new JFrame();
                Evite.fenetre.setTitle("Évite - ISN");
                Evite.fenetre.setSize(1080, 720);
                Evite.fenetre.setContentPane(new Game());
                Evite.fenetre.setUndecorated(true);
                Evite.fenetre.setResizable(false);
                Evite.fenetre.setLocationRelativeTo(null);
                Evite.fenetre.setVisible(true);

                Evite.fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        this.add(jouer);

        facile = new CustomButton("", Evite.ResourcePath + "textures/buttons/Facile.png", Evite.ResourcePath + "textures/buttons/FacileH.png");
        facile.setBounds(127, 442, 191, 66);
        facile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.isFacile = false;
                fr.evite.Evite.mainMenu.remove(facile);
                fr.evite.Evite.mainMenu.add(difficile);
                fr.evite.Evite.mainMenu.repaint();
            }
        });

        difficile = new CustomButton("", Evite.ResourcePath + "textures/buttons/Difficile.png", Evite.ResourcePath + "textures/buttons/DifficileH.png");
        difficile.setBounds(127, 442, 191, 66);
        difficile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.isFacile = true;
                fr.evite.Evite.mainMenu.remove(difficile);
                fr.evite.Evite.mainMenu.add(facile);
                fr.evite.Evite.mainMenu.repaint();
            }
        });

        if(Game.isFacile){
            this.add(facile);
        } else {
            this.add(difficile);
        }

        CustomButton quitter = new CustomButton("", Evite.ResourcePath + "textures/buttons/quit.png", Evite.ResourcePath + "textures/buttons/quitH.png");
        quitter.setBounds(1028, 20, 32, 32);
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(quitter);

        CustomButton minus = new CustomButton("", Evite.ResourcePath + "textures/buttons/minus.png", Evite.ResourcePath + "textures/buttons/minusH.png");
        minus.setBounds(979, 20, 32, 32);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evite.fenetre.setExtendedState(Frame.ICONIFIED);
            }
        });
        this.add(minus);
    }

    public void paintComponent(Graphics g)
    {
        background = new ImageIcon(Evite.ResourcePath + "textures/mainmenu/bg.gif").getImage();
        g.drawImage(background, 0, 0, this);
    }

    public static MainMenu getInstance(){ return instance; }

}
