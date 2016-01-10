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

import java.util.Set;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.iterator.LeafIterator;

/**
 * Represent an individual process step.
 */
public class ProcessStep extends ProcessComponent {
    /**
     * Create a step with the given name.
     * 
     * @param name
     *            the name of this process step
     */
    public ProcessStep(String name) {
        super(name);
    }

    /**
     * This hook lets visitors add behaviors to the process composite. The point
     * here is to call back the visitor indicating the type of this node, namely
     * ProcessStep.
     */
    public void accept(ProcessVisitor v) {
        v.visit(this);
    }

    public ComponentIterator iterator(Set visited) {
        return new LeafIterator(this, visited);
    }
    
    /**
     * @return the number of steps in this step, namely 1.
     * @param visited
     *            components already visited while traversing this component
     */
    public int getStepCount(Set visited) {
        visited.add(name);
        return 1;
    }
}