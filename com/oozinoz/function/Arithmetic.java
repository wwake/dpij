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
 * Wrap an arithmetic function around a pair of supplied sources.
 */
public class Arithmetic extends Function {
    protected char op;

    /**
     * Construct an arithmetic function that decorates the provided source
     * functions.
     * 
     * @param f1
     *            Another function wrapper
     * @param f2
     *            Yet another function wrapper
     */
    public Arithmetic(char op, Function f1, Function f2) {
        super(new Function[] { f1, f2 });
        this.op = op;
    }

    /**
     * @return an arithmetic operation (as indicated in the constructor) applied
     *         to the source functions' values at time t.
     * @param t
     *            time
     */
    public double f(double t) {
        switch (op) {
        case '+':
            return sources[0].f(t) + sources[1].f(t);
        case '-':
            return sources[0].f(t) - sources[1].f(t);
        case '*':
            return sources[0].f(t) * sources[1].f(t);
        case '/':
            return sources[0].f(t) / sources[1].f(t);
        default:
            return 0;
        }
    }
}