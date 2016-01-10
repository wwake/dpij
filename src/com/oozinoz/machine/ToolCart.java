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
*  Represent a tool cart.
*/
public class ToolCart implements VisualizationItem {
    protected Engineer responsible;

    /**
    *  Construct a tool cart, noting the engineer who
    *  is responsible for the tools on this cart.
    * @param e the responsible engineer
    */
    public ToolCart(Engineer e) {
        this.responsible = e;
    }

    /**
    *  @return The engineer who is responsible for tools in
    *  this tool's tool cart.
    */
    public Engineer getResponsible() {
        return responsible;
    }

    public void setResponsible(Engineer value) {
        this.responsible = value;
    }
}