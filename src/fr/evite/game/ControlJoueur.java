package fr.evite.game;

import fr.evite.Evite;
import fr.evite.MainMenu;
import fr.evite.utils.MapManager;
import fr.evite.utils.sound.SoundManager;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class ControlJoueur extends JPanel implements KeyListener, ActionListener
{
    private boolean pause = false;

    Timer shapeTimer = new Timer(5, this);

    Image level;
    Image levelPlayable;

    int joueurTaille = 40;

    double joueurX = 540, joueurY = 680, movementX = 0, ennemiX = 0, ennemiY = 0, ennemiMovementY = 10;

    public ControlJoueur()
    {
        shapeTimer.start();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        SoundManager.playRandomSong();

        ennemiX = getRandomNumberInRange(340, 740-joueurTaille);
        
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        level = new ImageIcon(MapManager.selectRandomMap()).getImage();
        g2.drawImage(level, 0, 0, this);

        levelPlayable = new ImageIcon(Evite.ResourcePath + "textures/maps/map1UP.png").getImage();
        g2.drawImage(levelPlayable, 0, 0, this);

        Rectangle2D ennemi = new Rectangle2D.Double(ennemiX, ennemiY, joueurTaille, joueurTaille);
        g2.fill(ennemi);
        g2.draw(ennemi);

        Rectangle2D joueur = new Rectangle2D.Double(joueurX, joueurY, joueurTaille, joueurTaille);
        g2.fill(joueur);
        g2.draw(joueur);

        if(ennemi.intersects(joueur)){
            SoundManager.pause(SoundManager.getCurrentSong());
            Evite.fenetre.setContentPane(new MainMenu());
            Evite.fenetre.validate();
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        repaint();

        if(!pause){
            ennemiY += ennemiMovementY;
            if(ennemiY >= this.getWidth()-joueurTaille){
                ennemiY = 0;
                ennemiX = getRandomNumberInRange(340, 740-joueurTaille);
                ennemiMovementY = getRandomNumberInRange(10, 20);
            }

            joueurX += movementX;
        }


    }


    public void moveLeft()
    {
        if (joueurX <= 340 || pause)
        {
            movementX = 0;

            return;
        }

        movementX = -10;
    }

    public void moveRight()
    {
        if (joueurX >= 740-joueurTaille || pause)
        {
            movementX = 0;
            return;
        }

        movementX = 10;
    }


    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(!pause){
            if (keyCode == KeyEvent.VK_RIGHT)
            {
                moveRight();
            }

            if (keyCode == KeyEvent.VK_LEFT)
            {
                moveLeft();
            }
        }

        if(keyCode == KeyEvent.VK_ESCAPE)
        {
            pause();
        }

    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_RIGHT)
        {
            movementX = 0;
        }

        if (keyCode == KeyEvent.VK_LEFT)
        {
            movementX = 0;
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private void pause(){
        if(pause){
            SoundManager.replay(SoundManager.getCurrentSong());
            pause = false;
        } else {
            SoundManager.pause(SoundManager.getCurrentSong());
            pause = true;
        }
    }
}
