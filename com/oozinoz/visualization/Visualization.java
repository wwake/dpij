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

import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.oozinoz.ui.UI;

/** This class provides a visualization of a factory that contains
 *  machines and through which material flows. At present the only
 *  functionality is the ability to create and drag machines. In the
 *  future we'll add operational modeling functions.
 */
public class Visualization extends JPanel implements ChangeListener {
	protected UI ui;

	protected JPanel machinePanel;

	protected JPanel buttonPanel;

	protected JButton addButton;

	protected JButton undoButton;

	protected Icon image = UI.getIcon("images/machine.png");

	protected FactoryModel factoryModel = new FactoryModel();

	protected VisMediator mediator;

	public Visualization(UI ui) {
		super(new BorderLayout());
		this.ui = ui;
		mediator = new VisMediator(factoryModel);
		factoryModel.addChangeListener(this);
		add(machinePanel(), BorderLayout.CENTER);
		add(buttonPanel(), BorderLayout.SOUTH);
	}

	protected JPanel machinePanel() {
		if (machinePanel == null) {
			machinePanel = new JPanel(null);
			machinePanel.setBackground(Color.WHITE);
			machinePanel.setPreferredSize(new Dimension(600, 500));
		}
		return machinePanel;
	}

	protected JPanel buttonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(addButton());
			buttonPanel.add(undoButton());
		}
		return buttonPanel;
	}

	protected JButton addButton() {
		if (addButton == null) {
			addButton = ui.createButtonOk();
			addButton.setText("Add");
			addButton.addActionListener(mediator.addAction());
		}
		return addButton;
	}

	protected JButton undoButton() {
		if (undoButton == null) {
			undoButton = ui.createButtonCancel();
			undoButton.setText("Undo");
			undoButton.setEnabled(false);
			undoButton.addActionListener(mediator.undoAction());
		}
		return undoButton;
	}

	// Create a standard picture of a machine
	protected Component createPictureBox(Point p) {
		Component result = new JButton("machine", image);
		result.setSize(128, 128);
		result.setLocation(p);

		result.addMouseListener(mediator.mouseDownAction());
		return result; 
	}

	public void stateChanged(ChangeEvent e) {
		machinePanel().removeAll();

		List locations = factoryModel.getLocations();

		for (int i = 0; i < locations.size(); i++) {
			Point p = (Point) locations.get(i);
			machinePanel().add(createPictureBox(p));
		}

		undoButton().setEnabled(factoryModel.canUndo());

		repaint();
	}
}