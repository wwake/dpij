package com.oozinoz.ui;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker. Steve Metsker makes no
 * representations or warranties about the fitness of this software for any
 * particular purpose, including the implied warranty of merchantability. Please
 * use this software as you wish with the sole restriction that you may not
 * claim that you wrote it.
 */

import javax.swing.JPanel;

public class OzPanel extends JPanel implements Cloneable {

    public OzPanel copy() {
        return (OzPanel) this.clone();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ignored) {
            throw new InternalError("OzPanel.clone() failed");
        }
    }

    public OzPanel copy2() {
        OzPanel result = new OzPanel();
        result.setBackground(this.getBackground());
        result.setForeground(this.getForeground());
        result.setFont(this.getFont());
        return result;
    }
}