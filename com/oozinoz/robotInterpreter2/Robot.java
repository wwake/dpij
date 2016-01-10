package com.oozinoz.robotInterpreter2;

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

import com.oozinoz.machine.Bin;
import com.oozinoz.machine.Machine;

/**
*  This class models a track robot that slides along a track
*  (a rail) and picks and places bins of material from
*  processing machines.
*/
public class Robot {
    public static final Robot singleton = new Robot();

    private Robot() {
    }

    /**
    *  Move to a machine, pick up a bin, move to another machine,
    *  and place the bin.
    *  @param m1 the "from" machine
    *  @param m2 the "to" machine
    */
    public void carry(Machine m1, Machine m2) {
        System.out.println("Robot carrying from " + m1 + " to " + m2);
        Bin b = m1.unload();
        if (b != null)
            m2.load(b);
    }
}