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

import com.oozinoz.planning.*;

/**
 * An unload buffer is a conveyor that contains bins of completed material.
 * 
 * @author Steven J. Metsker
 *  
 */
public class UnloadBuffer extends Machine {
    /**
     * Return a basic planner, since unload buffers are pretty predictable.
     * 
     * @return a basic planner
     */
    public MachinePlanner createPlanner() {
        return new BasicPlanner(this);
    }

    /**
     * Create a buffer with the given id and with the supplied parent machine.
     * 
     * @param id
     *            the identity of this unload buffer
     * @param parent
     *            the composite this machine belongs to
     */
    public UnloadBuffer(int id, MachineComponent parent) {
        super(id, parent);
    }

    /**
     * Create a buffer with the given id.
     * 
     * @param id
     *            the identity of this unload buffer
     */
    public UnloadBuffer(int id) {
        super(id);
    }

    /**
     * Create a buffer with the given id and with access to the mediator that
     * will control bin/machine relations.
     * 
     * @param id
     *            the identity of this unload buffer
     * @param Mediator
     *            the mediator that controls this machine's relation to bins
     */
    protected UnloadBuffer(int id, TubMediator mediator) {
        this(id, mediator, null);
    }

    /**
     * Create a buffer with the given id, with access to the mediator that will
     * control bin/machine relations, and with the supplied parent machine.
     * 
     * @param id
     *            the identity of this unload buffer
     * @param Mediator
     *            the mediator that controls this machine's relation to bins
     * @param parent
     *            the composite this machine belongs to
     */
    public UnloadBuffer(int id, TubMediator mediator, MachineComponent parent) {
        super(id, mediator, parent);
    }
}