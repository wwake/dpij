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

/**
 * Carry a bin from one machine to another, allowing for machines to be referred
 * to with variable names.
 */
public class CarryCommand extends Command {
    protected Term from;
    protected Term to;

    /**
     * Construct a "carry" command to carry a bin from one machine to another.
     * @param fromTerm the variable or constant that points to a machine to pick
     *            up a bin from
     * @param toTerm the variable or constant that points to a machine to place
     *            a bin on
     */
    public CarryCommand(Term fromTerm, Term toTerm) {
        from = fromTerm;
        to = toTerm;
    }

    /**
     * Evaulate this object's terms into machines, and carry a bin from the
     * "from" machine to the "to" machine.
     */
    public void execute() {
        Robot.singleton.carry(from.eval(), to.eval());
    }
}