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
 * Wrap the Math.Abs() function around a given source.
 */
public class Abs extends Function {
    /**
     * Construct an absolute value function that decorates the provided source
     * function.
     * 
     * @param f
     *            Another function wrapper
     */
    public Abs(Function f) {
        super(f);
    }

    /**
     * @return the absolute value of the source function value at time t
     * @param t
     *            time
     */
    public double f(double t) {
        return Math.abs(sources[0].f(t));
    }
}