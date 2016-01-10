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
import java.util.Set;

import com.oozinoz.process.ProcessComponent;

public class CompositeIterator extends ComponentIterator {
    protected Object peek;
    protected Iterator children;
    protected ComponentIterator subiterator;

    public CompositeIterator(Object head, List components, Set visited) {
        super(head, visited);
        children = components.iterator();
    }

    public int getDepth() {
        if (subiterator != null) 
            return subiterator.getDepth() + 1;
        return 0;
    }

    public boolean hasNext() {
        if (peek == null) 
            peek = next();
        return peek != null;
    }

    public Object next() {
        if (peek != null) {
            Object result = peek;
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
    protected Object nextDescendant() {
        while (true) {
            if (subiterator != null) {
                if (subiterator.hasNext()) return subiterator.next();
            }

            if (!children.hasNext()) return null;

            ProcessComponent pc = (ProcessComponent) children.next();
            if (!visited.contains(pc)) {
                subiterator = pc.iterator(visited);
                subiterator.setShowInterior(shouldShowInterior());
            }
        }
    }
}
