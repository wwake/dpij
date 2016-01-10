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

import java.awt.Font;
import javax.swing.JButton;

import com.oozinoz.ui.UI;

/**
 * Shows an Abstract Factory where a GUI kit can introduce a small change to
 * look-and-feel.
 */
public class BetaUI extends UI {
    public BetaUI() {
        Font oldFont = getFont();
        font = new Font(oldFont.getName(), oldFont.getStyle() | Font.ITALIC, oldFont.getSize());
    }

    public JButton createButtonOk() {
        JButton b = super.createButtonOk();
        b.setIcon(getIcon("images/cherry-large.gif"));
        return b;
    }

    public JButton createButtonCancel() {
        JButton b = super.createButtonCancel();
        b.setIcon(getIcon("images/cherry-large-down.gif"));
        return b;
    }
}