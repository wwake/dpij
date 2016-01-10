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
 * This class shows a refactoring of its MachineController predecessor. The
 * abstract operations are now moved out into an interface for drivers.
 * @author Steven J. Metsker
 */
public class MachineManager2 {
    protected MachineDriver driver;

    public MachineManager2(MachineDriver driver) {
        this.driver = driver;
    }

    public void shutdown() {
        driver.stopProcess();
        driver.conveyOut();
        driver.stopMachine();
    }
}