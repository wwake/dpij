package com.oozinoz.function;

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

/**
 * This is the identity function--t itself. This is often useful; for example if
 * you want the x coordinates of a Cartesion function to vary 0 to 1 you can use
 * T directly.
 */
public class T extends Function {
    /**
     * Construct the identity function that returns the value of t.
     */
    public T() {
        super(new Function[] {});
    }

    /**
     * @return the current value of t.
     * @param t
     *            time
     */
    public double f(double t) {
        return t;
    }
}