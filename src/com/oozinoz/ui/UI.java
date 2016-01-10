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
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

/**
 * User interface utilities.
 */

public class UI {
	protected Font font = new Font("Book Antiqua", Font.PLAIN, 18);

	public static final int STANDARD_PAD = 10;

	public static final UI NORMAL = new UI();

	/**
	 * @return a standard font that subclasses can override
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @return a standard padding amount that subclasses can override
	 */
	public int getPad() {
		return STANDARD_PAD;
	}

    /**
     * @return a standard button
     */
    public JButton createButton() {
        JButton button = new JButton();
        button.setSize(128, 128);
        button.setFont(getFont());
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        return button;
    }

    /**
	 * @return a standard OK! (or affirmation) button
	 */
	public JButton createButtonOk() {
		JButton button = createButton();
		button.setIcon(getIcon("images/rocket-large.gif"));
		button.setText("Ok!");
		return button;
	}

	/**
	 * @return a standard Cancel! (or negation) button
	 */
	public JButton createButtonCancel() {
		JButton button = createButton();
		button.setIcon(getIcon("images/rocket-large-down.gif"));
		button.setText("Cancel!");
		return button;
	}

	/**
	 * @return a panel with a standard amount of padding around any controls
	 */
	public JPanel createPaddedPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(
            BorderFactory.createEmptyBorder(getPad(), getPad(), getPad(), getPad()));
		return panel;
	}

	/**
	 * @return a panel with a standard amount of padding around any particular
	 *         control
	 * @param c
	 *            the control
	 */
	public JPanel createPaddedPanel(Component c) {
		JPanel panel = createPaddedPanel();
		panel.add(c);
		return panel;
	}
    
    public static Icon getIcon(String imageName) {
        return new ImageIcon(imageName);
    }

    public JList createList(Object[] contents) {
        JList result = new JList(contents);
        result.setFont(getFont()); 
        result.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return result;
    }
    
    /**
     * @return a titled border with the given title.
     */
    public TitledBorder createTitledBorder(String title) {
        TitledBorder border = BorderFactory.createTitledBorder(
            BorderFactory.createBevelBorder(BevelBorder.RAISED), 
            title,
            TitledBorder.LEFT, 
            TitledBorder.TOP);
        border.setTitleColor(Color.black);
        border.setTitleFont(getFont());
        return border;
    }
    
    /**
     * @return a new panel that wraps a titled border around a given panel.
     */
    public JPanel createTitledPanel(String title, JPanel in) {
        JPanel out = new JPanel();
        out.add(in);
        out.setBorder(createTitledBorder(title));
        return out;
    }
}
