package com.oozinoz.ui;

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

import java.awt.*;
import javax.swing.*;

/**
 * This class shows the idea of establishing user interface kits with
 * prototypical components.
 */
public class UIKit {
    protected OzButton button = new OzButton();

    protected OzTextArea textArea = new OzTextArea();

    /**
     * @return a (copy of a prototypical) button
     */
    public JButton createButton(String text) {
        JButton b = new JButton(text);
        b.setFont(button.getFont());
        return b;
    }

    /**
     * @return a (copy of a prototypical) text area
     */
    public OzTextArea createTextArea() {
        return (OzTextArea) textArea.clone();
    }

    /**
    * @return a kit for full-screen user interfaces
     */
    public static UIKit fullScreen() {
        Font font = new Font("Dialog", Font.ITALIC, 18);
        UIKit kit = new UIKit();
        kit.button.setFont(font);
        kit.textArea.setFont(font);
        return kit;
    }

    /**
     * @return a kit for handheld device user interfaces
     */
    public static UIKit handheld() {
        UIKit kit = new UIKit();
        Font font = new Font("Dialog", Font.PLAIN, 8);
        kit.button.setFont(font);
        kit.textArea = new OzTextArea();
        kit.textArea.setFont(font);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        kit.textArea.setCursor(cursor);
        return kit;
    }
}