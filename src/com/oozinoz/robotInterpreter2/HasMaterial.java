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
 * Represent the condition that a machine, referred to through a term, is not
 * empty.
 */
public class HasMaterial extends Term {
    protected Term term;

    /**
     * Construct a term that represent a Boolean function regarding whether the
     * term refers to a machine that has material.
     * 
     * @param term
     *            the term (usuaully a variable or machine) to check
     */
    public HasMaterial(Term term) {
        this.term = term;
    }

    /**
     * @return null if this term's subterm evaluates to a machine that has no
     *         material. Otherwise return the machine.
     */
    public Machine eval() {
        Machine m = term.eval();
        return m.hasMaterial() ? m : null;
    }
}