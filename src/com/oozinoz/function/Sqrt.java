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
 * Wrap the Math.sqrt() function around a given source.
 */
public class Sqrt extends Function {
    /**
     * Construct a square root function that decorates the provided source
     * function.
     * 
     * @param f
     *            Another function wrapper
     */
    public Sqrt(Function f) {
        super(f);
    }

    /**
     * @param t
     *            time
     * @return the square root of the source function value at time t
     */
    public double f(double t) {
        return Math.sqrt(sources[0].f(t));
    }
}