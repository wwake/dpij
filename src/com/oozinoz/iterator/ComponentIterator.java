package com.oozinoz.iterator;

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

import java.util.*;

/**
 * This is the abstract superclass of enmerators that can walk across leaf nodes
 * and composite nodes in a composite structure.
 */
public abstract class ComponentIterator implements Iterator {
    protected Object head;

    protected Set visited;

    protected boolean returnInterior = true;

    /**
     * Create an enumerator over a node in a composite.
     * @param node the node to iterate over
     * @param visited a set to track visited nodes
     */
    public ComponentIterator(Object head, Set visited) {
        this.head = head;
        this.visited = visited;
    }

    public boolean shouldShowInterior() {
        return returnInterior;
    }

    public void setShowInterior(boolean value) {
        returnInterior = value;
    }

    /**
     * @return the current depth of the iteration (number of nodes above the
     *         current node)
     */
    public abstract int getDepth();

    public void remove() {
        throw new UnsupportedOperationException("ComponentIterator.Remove");
    }
}