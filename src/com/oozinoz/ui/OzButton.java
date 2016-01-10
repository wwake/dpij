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

import javax.swing.*;

/**
 * This class acts as a prototypical button that applications can clone to get a
 * standard look and feel.
 */
public class OzButton extends JButton {
    /**
     * You might consider limiting constructor visibility for a component like
     * this to package visibility.
     */
    OzButton() {
    }

    /**
     * @return a copy of a prototypical button
     */
    public Object clone() {
        OzButton b = new OzButton();
        b.setFont(getFont());
        b.setCursor(getCursor());
        return b;
    }
}