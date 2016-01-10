package com.oozinoz.visualization;

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

import java.awt.event.*;
import javax.swing.*;
import com.oozinoz.ui.*;

/**
 * This version of the visualization adds a menu that
 * provides for saving and restoring mementos from a file.
 */ 
public class Visualization2 extends Visualization {
    public static void main(String[] args) {
        Visualization2 panel = new Visualization2(UI.NORMAL);
        JFrame frame = SwingFacade.launch(panel, "Operational Model");
        frame.setJMenuBar(panel.menus());
        frame.setVisible(true);
    }

    public Visualization2(UI ui) {
        super(ui);
    }

    public JMenuBar menus() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Save As...");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        menu.add(menuItem);

        menuItem = new JMenuItem("Restore From...");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restore();
            }

        });
        menu.add(menuItem);

        return menuBar;
    }

    public void save() {
        try {
            mediator.save(this);
        } catch (Exception ex) {
            System.out.println("Failed save: " + ex.getMessage());
        }
    }

    public void restore() {
        try {
            mediator.restore(this);
        } catch (Exception ex) {
            System.out.println("Failed restore: " + ex.getMessage());
        }
    }
}