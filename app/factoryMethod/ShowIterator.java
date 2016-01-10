package app.factoryMethod;

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
 * Show the (normally irrelevant) type of an iterator.
 * 
 * @author Steven J. Metsker
 */
public class ShowIterator {
    public static void main(String[] args) {
        List list = Arrays.asList(
                new String[] { "fountain", "rocket", "sparkler" });
        
        Iterator iter = list.iterator();
        
        while (iter.hasNext()) 
            System.out.println(iter.next());
        
        // Uncomment the next line to see the iterator's actual class:
        // System.out.println(iter.getClass().getName());
    }
}