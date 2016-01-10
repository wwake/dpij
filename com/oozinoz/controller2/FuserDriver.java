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

import com.oozinoz.controller.FuserController;

/**
*  A machine manager that adapts the common interface of
*  the MachineManager class to the specific protocol of
*  a fuser controller.
*/
public class FuserDriver implements MachineDriver {
    private FuserController controller = new FuserController();

    public void startMachine() {
        controller.startMachine();
    }

    public void stopMachine() {
        controller.stopMachine();
    }

    public void startProcess() {
        controller.begin();
    }

    public void stopProcess() {
        controller.end();
    }

    public void conveyIn() {
        controller.conveyIn();
    }

    public void conveyOut() {
        controller.conveyOut();
    }

    public void switchSpool() {
        controller.switchSpool();
    }
}