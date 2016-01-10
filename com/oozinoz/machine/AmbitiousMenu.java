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
 * This (dysfunctional) class shows a method from an overly ambitious menu that
 * figures out who the responsible engineer is for a piece of equipment. In the
 * "Chain of Responsibility" chapter of "Design Patterns in Java," this code is
 * refactored so that the domain objects determine who is the responsible
 * engineer.
 */
public class AmbitiousMenu {
    /**
     * @param item The interesting item
     * @return The engineer who is responsible for item
     */
    public Engineer getResponsible(VisualizationItem item) {
        if (item instanceof Tool)
        {
            Tool t = (Tool) item;
            return t.getToolCart().getResponsible();
        }
        if (item instanceof ToolCart) {
            ToolCart tc = (ToolCart) item;
            return tc.getResponsible();
        }
        if (item instanceof MachineComponent) {
            MachineComponent c = (MachineComponent) item;
            if (c.getResponsible() != null) 
                return c.getResponsible();

            if (c.getParent() != null) 
                return c.getParent().getResponsible();
        }
        return null;
    }
}