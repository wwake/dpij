package com.oozinoz.controller;

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
*  A machine manager that adapts the common interface of
*  the MachineManager class to the specific protocol of
*  a star press controller.
*/
public class StarPressManager extends MachineManager {
    private StarPressController controller = new StarPressController();

    public void startMachine() {
        controller.start();
    }

    public void stopMachine() {
        controller.stop();
    }

    public void startProcess() {
        controller.startProcess();
    }

    public void stopProcess() {
        controller.endProcess();
    }

    public void conveyIn() {
        controller.index();
    }

    public void conveyOut() {
        controller.discharge();
    }
}