package com.oozinoz.controller2;

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
 * This interface defines the abstract operations that a machine controller
 * needs.
 * @author Steven J. Metsker
 */
public interface MachineDriver {
    public abstract void startMachine();
    public abstract void stopMachine();
    public abstract void startProcess();
    public abstract void stopProcess();
    public abstract void conveyIn();
    public abstract void conveyOut();
}