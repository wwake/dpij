package app.observer.ballistics3;

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

import com.oozinoz.utility.Format;

import java.util.*;

/**
 * Instances of this class are labels that show the value of a Tpeak model.
 * 
 * @author Steven J. Metsker
 */
public class BallisticsLabel extends JLabel implements Observer {
    /**
     * Construct a label that will show the value of a Tpeak object.
     * 
     * @param tPeak
     *            the model to observe
     */
    public BallisticsLabel(Tpeak tPeak) {
        tPeak.addObserver(this);
    }

    /**
     * Respond to a change in the observed Tpeak model
     * 
     * @param Observable
     *            presumably the model we are observing
     * @param arg
     *            ignored
     */
    public void update(Observable obj, Object arg) {
        setText(Format.formatToNPlaces(((Tpeak) obj).getValue(), 2));
        repaint();
    }
}