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
*  A planner for estimating when a shell assembler will
*  become available.
*/
public class ShellPlanner extends MachinePlanner {
    public ShellPlanner(Machine m) {
        super(m);
    }

    /**
    *  Say when this planner's machine will be available; this
    *  method is not yet actually implemented.
    */
    public Date getAvailable() {
        return new Date();
    }
}