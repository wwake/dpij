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

import com.oozinoz.machine.Machine;

/**
 * This class represents a command to shut down a machine indicated by a
 * provided term.
 */
public class ShutDownCommand extends Command {
    protected Term term;

    /**
     * Construct a command to shut down a machine indicated by the provided
     * term.
     * @param term a term to evaulate when this command executes; the machine it
     *            evaulates to will be shut down
     */
    public ShutDownCommand(Term term) {
        this.term = term;
    }

    /**
     * Evaluate this object's term to a machine and shut down that machine.
     */
    public void execute() {
        Machine m = term.eval();
        m.shutdown();
    }
}