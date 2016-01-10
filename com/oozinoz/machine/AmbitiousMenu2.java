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
 * This class shows the value of refactoring the AmbitiousMenu class using Chain
 * of Responsibility.
 */
public class AmbitiousMenu2 {
    /**
     * @param item The interesting item
     * @return The engineer who is responsible for the item
     */
    public Engineer getResponsible(VisualizationItem item) {
        return item.getResponsible();
    }
}