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

import java.util.Observable;

/**
 * Instances of this class provide an observably changeable model of the time at
 * which a fuel's burn area peaks.
 * 
 * @author Steven J. Metsker
 */
public class Tpeak extends Observable {
    protected double value;

    /**
     * Create a model of the time at which a fuel's burn area peaks.
     * 
     * @param value
     *            the initial peak time
     */
    public Tpeak(double value) {
        this.value = value;
    }

    /**
     * @return the current value of the peak time
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value
     *            the new value for the peak time
     */
    public void setValue(double value) {
        this.value = value;
        setChanged();
        notifyObservers();
    }
}