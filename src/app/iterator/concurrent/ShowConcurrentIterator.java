package app.iterator.concurrent;

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
 * Show that modifying a list while an iterator iterates over it causes an
 * exception.
 */
public class ShowConcurrentIterator implements Runnable {
    private List list;

    protected static List upMachineNames() {
        return new ArrayList(Arrays.asList(new String[] { "Mixer1201",
                "ShellAssembler1301", "StarPress1401", "UnloadBuffer1501" }));
    }

    public static void main(String[] args) {
        new ShowConcurrentIterator().go();
    }

    protected void go() {
        list = Collections.synchronizedList(upMachineNames());
        Iterator iter = list.iterator();
        int i = 0;
        while (iter.hasNext()) {
            i++;
            if (i == 2) { // simulate wake-up
                new Thread(this).start();
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
            System.out.println(iter.next());
        }
    }

    /**
     * Insert an element in the list, in a separate thread.
     */
    public void run() {
        list.add(0, "Fuser1101");
    }
}