package app.iterator.process;

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

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.process.ProcessComponent;
import com.oozinoz.process.ShellProcess;

public class ShowLeavesOnly {
    public static void main(String[] args) {
        ProcessComponent pc = ShellProcess.make();
        ComponentIterator iter = pc.iterator();
        iter.setShowInterior(false);
        
        while (iter.hasNext()) 
            System.out.println(iter.next());
    }
}
