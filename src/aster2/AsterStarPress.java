package aster2;

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
 * This class is a revision of the AsterStarPress class that uses the Command
 * pattern to let a client modify its behavior.
 * 
 * The "Command" chapter in "Design Patterns in Java" describes this class.
 */
public class AsterStarPress {
    public Hook moldIncompleteHook;
    
    protected int currentMoldID;

    public AsterStarPress() {
        moldIncompleteHook = new NullHook();
    }
    
    public void setMoldIncompleteHook(Hook hook) {
        moldIncompleteHook = hook;
    }
    /**
     * ID of the mold that is in the processing area.
     */
    public int getCurrentMoldID() {
        return currentMoldID;
    }

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
     * @return true if the machine is processing a mold
     */
    public boolean inProcess() {
        return false;
    }

    /**
     * Stop processing, mark the current mold as incomplete, move off all molds,
     * discharge any prepared paste, and flush the processing area with water.
     */
    public void shutDown() {
        if (inProcess()) {
            stopProcessing();
            moldIncompleteHook.execute(this);
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