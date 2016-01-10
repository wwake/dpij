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

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** A model of a factory; at the moment this model just contains
 *  machine locations. However, the factory also provides support
 *  for undo by storing off mementos each time the factory
 *  configuration changes.
 */ 
public class FactoryModel {
	private Stack mementos;

	private ArrayList listeners = new ArrayList();

	public FactoryModel() {
		mementos = new Stack();
		mementos.push(new ArrayList()); // start empty
	}

	public void add(Point location) {
        List oldLocs = (List) mementos.peek();
		List newLocs = new ArrayList(oldLocs);
		newLocs.add(0, location);

		mementos.push(newLocs);
		notifyListeners();
	}

	public void drag(Point oldLocation, Point newLocation) {
		List oldLocs = (List) mementos.peek();
		List newLocs = new ArrayList(oldLocs);
		newLocs.remove(oldLocation);
		newLocs.add(0, newLocation);

		mementos.push(newLocs);
		notifyListeners();
	}

    public boolean canUndo() {
        return mementos.size() > 1;
    }

	public void undo() {
		if (!canUndo()) return;

		mementos.pop();
		notifyListeners();
	}

	public List getLocations() {
		return (List) mementos.peek();
	}

    public void setLocations(ArrayList list) {
        mementos.push(list);
        notifyListeners();
    }

    public void addChangeListener(ChangeListener listener) {
		listeners.add(listener);
	}

	public void notifyListeners() {
		for (int i = 0; i < listeners.size(); i++)
		    ((ChangeListener) listeners.get(i)).stateChanged(new ChangeEvent(this));
	}
}