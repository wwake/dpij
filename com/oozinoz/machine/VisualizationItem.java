package com.oozinoz.machine;

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
 *  This interface represents part of a user interface for a 
 *  simulation that the "Chain of Responsibility" chapter in 
 *  "Design Patterns in Java" discusses.
 */
public interface VisualizationItem {
    /**
     *  Return the engineer who is responsible for the machine
     *  that this simulated item represents.
     */
    Engineer getResponsible();
}