package app.observer.ballistics4;

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

import com.oozinoz.utility.Format;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Instances of this class are labels that show the value of a Tpeak model.
 * 
 * @author Steven J. Metsker
 */
public class BallisticsLabel extends JLabel implements PropertyChangeListener {
    /**
     * Construct a label that will show the value of a Tpeak object.
     * 
     * @param tPeak
     *            the model to observe
     */
    public BallisticsLabel(Tpeak tPeak) {
        tPeak.addObserver(this);
        showValue(tPeak.getValue());
    }

    /**
     * Respond to a change in the observed Tpeak model
     * 
     * @param evt
     *            change event
     */

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        showValue((double) evt.getNewValue());
    }

    private void showValue(double value) {
        setText(Format.formatToNPlaces(value, 2));
        repaint();
    }
}
