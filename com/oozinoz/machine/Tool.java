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
 * Represent a tool in an Oozinoz factory. Tools are like machines but are less
 * stationary. They roll around on tool carts.
 */
public class Tool implements VisualizationItem {
    protected ToolCart toolCart;

    /**
     * The tool cart to which this tool belongs.
     */
    public ToolCart getToolCart() {
        return toolCart;
    }

    public void setToolCart(ToolCart value) {
        toolCart = value;
    }

    /**
     * The engineer who is responsible for tools in this tool's tool cart.
     */
    public Engineer getResponsible() {
        return toolCart.getResponsible();
    }

}