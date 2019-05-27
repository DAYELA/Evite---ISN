package fr.evite;

import fr.evite.game.ControlJoueur;
import fr.evite.utils.CustomButton;
import fr.evite.utils.sound.SoundManager;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel
{

    private Image background;

    private static MainMenu instance;

    public MainMenu()
    {
        instance = this;
        this.setLayout(null);

        CustomButton jouer = new CustomButton("", Evite.ResourcePath + "textures/buttons/Jouer.png", Evite.ResourcePath + "textures/buttons/JouerH.png");
        jouer.setBounds(227, 334, 191, 66);
        jouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoundManager.play("PlayButton");
                Evite.fenetre.remove(Evite.mainMenu);
                Evite.fenetre.setContentPane(new ControlJoueur());
                Evite.fenetre.validate();
            }
        });
        this.add(jouer);

        CustomButton option = new CustomButton("", Evite.ResourcePath + "textures/buttons/Option.png", Evite.ResourcePath + "textures/buttons/OptionH.png");
        option.setBounds(227, 442, 191, 66);
        option.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(option);

        CustomButton quitter = new CustomButton("", Evite.ResourcePath + "textures/buttons/quit.png", Evite.ResourcePath + "textures/buttons/quitH.png");
        quitter.setBounds(1858, 30, 32, 32);
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(quitter);

        CustomButton minus = new CustomButton("", Evite.ResourcePath + "textures/buttons/minus.png", Evite.ResourcePath + "textures/buttons/minusH.png");
        minus.setBounds(1809, 30, 32, 32);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evite.fenetre.setExtendedState(Frame.ICONIFIED);
            }
        });
        this.add(minus);

        CustomButton sound = new CustomButton("", Evite.ResourcePath + "textures/buttons/sound.png", Evite.ResourcePath + "textures/buttons/soundH.png");
        sound.setBounds(1722, 17, 64, 64);
        sound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Evite.fenetre.setExtendedState(Frame.ICONIFIED);
            }
        });
        this.add(sound);
    }

    public void paintComponent(Graphics g)
    {
        background = new ImageIcon(Evite.ResourcePath + "textures/mainmenu/bg.gif").getImage();
        g.drawImage(background, 0, 0, this);
    }

    public static MainMenu getInstance(){ return instance; }

}
