package com.oozinoz.robotInterpreter;

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
    *  @param fromMachine the "from" machine
    *  @param toMachine the "to" machine
    */
    public void carry(Machine fromMachine, Machine toMachine) {
        System.out.println("Robot carrying from " + fromMachine + " to " + toMachine);
        Bin b = fromMachine.unload();
        if (b != null)
            toMachine.load(b);
    }
}