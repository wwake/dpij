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

import java.util.Set;

public class LeafIterator extends ComponentIterator {
    public LeafIterator(Object head, Set visited) {
        super(head, visited);
    }

    public int getDepth() {
        return 0;
    }

    public boolean hasNext() {
        return !visited.contains(head);
    }

    public Object next() {
        if (visited.contains(head)) return null;

        visited.add(head);
        return head;
    }

}
