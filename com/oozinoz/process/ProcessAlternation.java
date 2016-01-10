package com.oozinoz.process;

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

import java.util.List;

/**
 * Represent an "alternation" (a choice) of process steps.
 */
public class ProcessAlternation extends ProcessComposite {
    /**
     * Create an alternation with the given name.
     * 
     * @param name
     *            the name of this process alternation
     */
    public ProcessAlternation(String name) {
        super(name);
    }

    /**
     * Create an alternation with the given name and containing the given
     * subprocesses.
     * 
     * @param name
     *            the name of this alternation
     * @param subprocesses
     *            the children of this alternation
     */
    public ProcessAlternation(String name, ProcessComponent[] subprocesses) {
        super(name, subprocesses);
    }

    /**
     * Create an alternation with the given name and containing the given
     * subprocesses.
     */
    public ProcessAlternation(String name, List subprocesses) {
        super(name, subprocesses);
    }

    /**
     * This hook lets visitors add behaviors to the process composite. The point
     * here is to call back the visitor indicating the type of this node, namely
     * ProcessAlternation.
     */
    public void accept(ProcessVisitor v) {
        v.visit(this);
    }
}