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

import java.util.HashSet;
import java.util.Set;

import com.oozinoz.iterator.ComponentIterator;

/**
 * Objects of this class represent either individual process steps or
 * compositions of process steps. A process is essentially a recipe for
 * manufacturing something, notably fireworks.
 */
public abstract class ProcessComponent {
    protected String name;

    /**
     * Create a process component with the given name.
     * 
     * @param name
     *            this process component's name
     */
    public ProcessComponent(String name) {
        this.name = name;
    }

    /**
     * Accept a "visitor".
     * 
     * @param v
     *            the visitor
     */
    public abstract void accept(ProcessVisitor v);

    /**
     * @return the component's name.
     */
    public String getName() {
        return name;
    }

    public ComponentIterator iterator() {
        return iterator(new HashSet());
    }
    
    public abstract ComponentIterator iterator(Set visited);
    
    /**
     * @return the number of leaf node steps in this composite.
     */
    public int getStepCount() {
        return getStepCount(new HashSet());
    }

    /**
     * @return the number of leaf node steps in this composite.
     * @param visited
     *            components already visited while traversing this component
     */
    public abstract int getStepCount(Set visited);

    /**
     * @return a textual representation of this component.
     */
    public String toString() {
        return name;
    }
}