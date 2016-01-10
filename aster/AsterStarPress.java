package aster;

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
 * This class runs on the (fictional) Aster star press and aids communication
 * with the factory in which the star press runs. In fact this class is a
 * mock-up that shows how a client might supply a template method.
 * 
 * The "Template Method" chapter in "Design Patterns in C#" describes this
 * class.
 */
public abstract class AsterStarPress {
    protected int currentMoldID;

    /**
     * Extrude all of the chemical paste (used for firework stars) to waste
     * area.
     */
    public void dischargePaste() {
    }

    /**
     * Spray water over the processing and discharge areas, keeping the press
     * from getting gunky.
     */
    public void flush() {
    }

    /**
     * @return true if the machine is processing a mold.
     */
    public boolean inProcess() {
        return false;
    }

    /**
     * Subclasses have to fill in how the host factory can deal with the problem
     * of an incompletely processed mold.
     * 
     * @param id
     *            which mold is incomplete
     */
    public abstract void markMoldIncomplete(int id);

    /**
     * Stop processing, mark the current mold as incomplete, move off all molds,
     * discharge any prepared paste, and flush the processing area with water.
     */
    public void shutdown() {
        if (inProcess()) {
            stopProcessing();
            markMoldIncomplete(currentMoldID);
        }
        usherInputMolds();
        dischargePaste();
        flush();
    }

    /**
     * Stop the processing subassembly.
     */
    public void stopProcessing() {
    }

    /**
     * Move all molds to the output conveyor.
     */
    public void usherInputMolds() {
    }
}