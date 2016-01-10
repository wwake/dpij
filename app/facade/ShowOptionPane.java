package app.facade;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker.
 * 
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose, 
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

import javax.swing.*;

import java.awt.Font;

/**
 * Give a little demo of how JOptionPane lets you easily produce a dialog panel.
 */
public class ShowOptionPane {
    public static void main(String[] args) {
        Font font = new Font("Dialog", Font.PLAIN, 18);
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);

        int option;
        do {
            option = JOptionPane.showConfirmDialog(null, "Had enough?",
                    " A Stubborn Dialog", JOptionPane.YES_NO_OPTION);
        } while (option == JOptionPane.NO_OPTION);
    }
}