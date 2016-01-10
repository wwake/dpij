package app.observer.ballistics2;

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
import javax.swing.event.*;

import com.oozinoz.utility.Format;

/**
 * Instances of this class are labels that show the value of a slider as a
 * percentage of the slider's progress from its minimum to its maximum.
 * 
 * @author Steven J. Metsker
 */
public class BallisticsLabel2 extends JLabel implements ChangeListener {
    /**
     * Update the label when the slider moves.
     * @param e ChangeEvent object (ignored)
     */
    public void stateChanged(ChangeEvent e) {
        double val = slider.getValue();
        double max = slider.getMaximum();
        double min = slider.getMinimum();
        double tPeak = (val - min) / (max - min);
        setText(Format.formatToNPlaces(tPeak, 2));
    }

    protected JSlider slider;

    /**
     * Construct a label that will show the value of a slider.
     * 
     * @param JSlider
     *            the slider to observe
     */
    public BallisticsLabel2(JSlider slider) {
        this.slider = slider;
        setText("0.00");
        slider.addChangeListener(this);
    }
}