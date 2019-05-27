package fr.evite.utils;

import fr.evite.utils.sound.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomButton extends JButton implements MouseListener {

    //crée un boutton avec texture et hover
    public CustomButton(String txt, String icon, String iconHover) {
        super(txt);
        setForeground(Color.WHITE);

        setOpaque(false);
        setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.

        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);

        addMouseListener(this);

        setIcon(new ImageIcon(icon));
        setRolloverIcon(new ImageIcon(iconHover));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        SoundManager.playHoverButton();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
