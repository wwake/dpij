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
 * Wrap the Math.sin() function around a given source.
 */
public class Sin extends Function {
    /**
     * Construct a sine function that decorates the provided source function.
     * 
     * @param f
     *            Another function wrapper
     */
    public Sin(Function f) {
        super(f);
    }

    /**
     * @param t
     *            time
     * @return the sin of the source function value at time t
     */
    public double f(double t) {
        return Math.sin(sources[0].f(t));
    }
}