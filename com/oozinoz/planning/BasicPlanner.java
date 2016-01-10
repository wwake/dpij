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
 * A generic planner for machines that don't have a machine-specific planner.
 */
public class BasicPlanner extends MachinePlanner {
    public BasicPlanner(Machine m) {
        super(m);
    }

    public Date getAvailable() {
        return new Date();
    }
}