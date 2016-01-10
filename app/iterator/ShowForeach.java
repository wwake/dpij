package app.iterator;

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
import java.util.Iterator;
import java.util.List;

public class ShowForeach {
    /** Show a JDK 1.2-style iterator and a JDK 1.5-style extended for loop.
     */
    public static void main(String[] args) {
        ShowForeach example = new ShowForeach();
        example.showIterator();
        
        System.out.println();
        example.showForeach();
    }

    public void showIterator() {
        List names = new ArrayList();
        names.add("Fuser:1101");
        names.add("StarPress:991");
        names.add("Robot:1");

        System.out.println("JDK 1.2-style Iterator:");
        for (Iterator it = names.iterator(); it.hasNext();) {
            String name = (String) it.next();
            System.out.println(name);
        }
    }

    public void showForeach() {
//        List<String> names = new ArrayList<String>();
//        names.add("Fuser:1101");
//        names.add("StarPress:991");
//        names.add("Robot:1");

//        System.out.println("JDK 1.5-style Extended For Loop:");
//        for (String name: names)
//           System.out.println(name);
    }
}
