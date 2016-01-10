package com.oozinoz.planning;

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

import java.util.Date;

import com.oozinoz.machine.Machine;

/**
 * Abstract superclass for classes that plan the expected behavior of machines.
 */
public abstract class MachinePlanner {
    protected Machine machine;

    public MachinePlanner(Machine m) {
        machine = m;
    }

    public abstract Date getAvailable();
}