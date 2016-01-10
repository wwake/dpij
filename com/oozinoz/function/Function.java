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
 * This abstract superclass defines the role of a function that wraps itself
 * around (or "decorates") another function.
 * 
 * The signature of function methods in this hierarchy is "double f(double time)".
 * Each class defines this function in a way that is consistent with the class
 * name.
 * 
 * The "time" argument is a value from 0 to 1 that represents a normalized
 * notion of time. For example, in the arc of a parabola, time goes 0 to 1 as x
 * goes 0 to the base of the arc and y goes 0 to the apogee (at t = .5) and back
 * to 0.
 */
public abstract class Function {
    protected Function[] sources;

    /**
     * Construct a function that decorates the provided source function.
     * 
     * @param f
     *            the source function that this function wraps
     */
    public Function(Function f) {
        this(new Function[] { f });
    }

    /**
     * Construct a function that decorates the provided source functions.
     * 
     * @param sources
     *            the source functions that this function wraps
     */
    public Function(Function[] sources) {
        this.sources = sources;
    }

    /**
     * The function that subclasses must implement -- see the subclases for
     * examples.
     * 
     * @param t
     *            normalized time, a value between 0 and 1
     * @return a function value
     */
    public abstract double f(double t);

    /**
     * @return a textual representation of this function.
     */
    public String toString() {
        String name = this.getClass().toString();
        StringBuffer buf = new StringBuffer(name);
        if (sources.length > 0) {
            buf.append('(');
            for (int i = 0; i < sources.length; i++) {
                if (i > 0)
                    buf.append(", ");
                buf.append(sources[i]);
            }
            buf.append(')');
        }
        return buf.toString();
    }
}