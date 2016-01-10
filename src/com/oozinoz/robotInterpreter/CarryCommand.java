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

import com.oozinoz.machine.Machine;

/**
*  Carry a bin from one machine to another, allowing for
*  machines to be referred to with variable names.
*/
public class CarryCommand extends Command {
    protected Machine fromMachine;

    protected Machine toMachine;

    /**
    *  Construct a "carry" command to carry a bin from
    *  one machine to another.
    *  @param fromMachine the machine to pick up a bin from
    *  @param toMachine the machine to place a bin on
    */
    public CarryCommand(Machine fromMachine, Machine toMachine) {
        this.fromMachine = fromMachine;
        this.toMachine = toMachine;
    }

    /**
    *  Evaulate this object's terms into machines, and carry a bin
    *  from the "from" machine to the "to" machine.
    */
    public void execute() {
        Robot.singleton.carry(fromMachine, toMachine);
    }
}