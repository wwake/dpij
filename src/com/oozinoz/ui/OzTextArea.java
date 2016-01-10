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
import javax.swing.border.*;

/**
 * This class acts as a prototypical text area that applications can clone to
 * get a standard look and feel.
 */
public class OzTextArea extends JPanel {
    protected JTextArea textArea = new JTextArea();

    protected TitledBorder border;

    /**
     * Create a standard, prototypical text area. This constructor places a
     * Swing text area inside a scroll pane with a standard border.
     */
    public OzTextArea() {
        setLayout(new BorderLayout());
        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createRaisedBevelBorder(), BorderFactory.createEmptyBorder(5,
                5, 5, 5)));
        add(jsp, "Center");
    }

    /**
     * Add the supplied text to this text area.
     * 
     * @param String
     *            the text to append
     */
    public void append(String text) {
        textArea().append(text);
    }

    /**
     * Remove all the text from this text area.
     */
    public void clear() {
        textArea().setText("");
    }

    /**
     * @return a copy of a prototypical text area
     */
    public Object clone() {
        OzTextArea ta = new OzTextArea();
        ta.setFont(textArea().getFont());
        ta.setCursor(getCursor());
        return ta;
    }

    public void setFont(Font font) {
        textArea().setFont(font);
    }

    protected JTextArea textArea() {
        if (textArea == null) {
            textArea = new JTextArea();
            textArea.setMargin(new Insets(20, 20, 20, 20));
        }
        return textArea;
    }
}