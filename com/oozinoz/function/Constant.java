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
 * Provide a "function" that ignores the time t parameter and always returns a
 * constant value.
 */
public class Constant extends Function {
    protected double constant;

    /**
     * Construct a "function" that ignores the time t parameter and always
     * returns a constant value.
     * 
     * @param constant
     *            the constant
     */
    public Constant(double constant) {
        super(new Function[] {});
        this.constant = constant;
    }

    /**
     * @return this object's constant value.
     * @param t
     *            time, ignored
     */
    public double f(double t) {
        return constant;
    }
}