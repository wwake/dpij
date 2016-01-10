package com.oozinoz.machine;

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

/**
 * This is a minimal model of a "bin," a large plastic rectangular basket that
 * holds fireworks materials as they go through the factory.
 */
public class Bin {
    private int id;

    /**
     * Create a bin with the given id.
     * @param id A unique number for this bin
     */
    public Bin(int id) {
        this.id = id;
    }
}