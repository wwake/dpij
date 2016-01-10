package com.oozinoz.businessCore;

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
 * This class supports various examples that rely on the idea of a central
 * object that represents an Oozinoz factory.
 */
public class Factory {
    private static Factory factory;

    private static Object classLock = Factory.class;

    private long wipMoves;

    private Factory() {
        wipMoves = 0;
    }

    public static Factory getFactory() {
        synchronized (classLock) {
            if (factory == null)
                factory = new Factory();

            return factory;
        }
    }

    public void recordWipMove() {
        synchronized (classLock) {
            wipMoves++;
        }
    }

    // for the Aster star press example; not implemented
    public void collectPaste() {
    }

    /**
     * @return an example list of "up" machines, supporting
     *         "ShowConcurrentWhile" and other examples).
     */
    public static ArrayList upMachineNames() {
        ArrayList result = new ArrayList();
        result.add("Mixer:1201");
        result.add("ShellAssembler:1301");
        result.add("StarPress:1401");
        result.add("UnloadBuffer:1501");
        return result;
    }
}