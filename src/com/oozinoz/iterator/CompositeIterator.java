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

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class CompositeIterator<E extends AcycliclyIterable<E>> extends ComponentIterator<E> {
    protected E peek;
    protected Iterator<E> children;
    protected ComponentIterator<E> subiterator;

    public CompositeIterator(E head, List<E> components, Set<E> visited) {
        super(head, visited);
        children = components.iterator();
    }

    public int getDepth() {
        if (subiterator != null) 
            return subiterator.getDepth() + 1;
        return 0;
    }

    public boolean hasNext() {
        try {
            if (peek == null)
                peek = next();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public E next() {
        if (peek != null) {
            E result = peek;
            peek = null;
            return result;
        }
        
        if (!visited.contains(head)) {
            visited.add(head);
            if (shouldShowInterior()) return head;
        }
        
        return nextDescendant();
    }

    /*
     * Usually just return the subiterator's next element. But if the
     * subiterator doesn't exist or doesn't have a next element, create an
     * iterator for the next child. (If there is no next child, just return
     * null.) Create an iterator for this child and return this iterator's next
     * element.
     */
    protected E nextDescendant() {
        while (true) {
            if (subiterator != null) {
                if (subiterator.hasNext()) return subiterator.next();
            }

            if (!children.hasNext()) throw new NoSuchElementException("No next element");

            E pc = children.next();
            if (!visited.contains(pc)) {
                subiterator = pc.iterator(visited);
                subiterator.setShowInterior(shouldShowInterior());
            }
        }
    }
}
