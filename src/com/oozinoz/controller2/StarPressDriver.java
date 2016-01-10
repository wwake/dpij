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

import com.oozinoz.controller.StarPressController;

/**
 * This class is a refactoring of StarPressController that occurs when you
 * refactor the MachineController_ hierarchy to use a bridge.
 * @author Steven J. Metsker
 */
public class StarPressDriver implements MachineDriver {
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