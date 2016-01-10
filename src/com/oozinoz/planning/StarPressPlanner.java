package com.oozinoz.planning;

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

import com.oozinoz.machine.*;

/**
 * This planner predicts when a star press will become available. A complete
 * implementation would probably consider many variables that affect a star
 * press.
 * 
 * @author Steven J. Metsker
 */
public class StarPressPlanner extends MachinePlanner {
    /**
     * Construct a new planner for a star press.
     */
    public StarPressPlanner(StarPress machine) {
        super(machine);
    }

    /**
     * Return a datetime when the star press that this planner represents will
     * next become available.
     * 
     * @return Date when the star press that this planner represents will next
     *         become available. In practice, this method would employ some
     *         operational modeling logic to determine this time.
     */
    public java.util.Date getAvailable() {
        // just return the current time, in this example
        return new java.util.Date();
    }
}