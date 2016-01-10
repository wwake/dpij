package com.oozinoz.robotInterpreter2;

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

import com.oozinoz.machine.Machine;

/**
 * Represent a comparison of two terms.
 */
public class Equals extends Term {
    protected Term term1;
    protected Term term2;

    /**
     * Construct a term that can compare the two provided terms.
     * 
     * @param term1
     *            a term to compare
     * @param term2
     *            another term to compare
     */
    public Equals(Term term1, Term term2) {
        this.term1 = term1;
        this.term2 = term2;
    }

    /**
     * @return null if this term's subterms evaluate to different machines.
     *         Otherwise return the machine.
     */
    public Machine eval() {
        Machine m1 = term1.eval();
        Machine m2 = term2.eval();
        return m1.equals(m2) ? m1 : null;
    }
}