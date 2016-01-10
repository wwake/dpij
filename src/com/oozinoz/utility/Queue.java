package com.oozinoz.utility;

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

import java.util.ArrayList;

public class Queue {
    private ArrayList queue;
    
    public Queue() {
        queue = new ArrayList();
    }
    
    public void enqueue(Object obj) {
        queue.add(obj);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public Object dequeue() {
        Object result = queue.get(0);
        queue.remove(0);
        return result;
    }
    
    public int size() {
        return queue.size();
    }
}
