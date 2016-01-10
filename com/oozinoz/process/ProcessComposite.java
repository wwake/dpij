package com.oozinoz.process;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.oozinoz.iterator.ComponentIterator;
import com.oozinoz.iterator.CompositeIterator;

/**
 * Represent either an alternation or a sequence of process steps.
 */
public abstract class ProcessComposite extends ProcessComponent {
    protected List subprocesses;

    /**
     * Create a process composite with the given name.
     * @param name this process composite's name
     */
    public ProcessComposite(String name) {
        this(name, new ArrayList());
    }

    /**
     * Create a composite with the given name and containing the given
     * subprocesses.
     * @param name the identity of this composite
     * @param existingProcesses the children of this composite
     */
    public ProcessComposite(String name, ProcessComponent[] existingProcesses) {
        super(name);
        subprocesses = new ArrayList();
        for (int i = 0; i < existingProcesses.length; i++)
            subprocesses.add(existingProcesses[i]);
    }

    /**
     * Create a composite with the given name and containing the given
     * subprocesses.
     * @param name the identity of this composite
     * @param subprocesses the children of this composite
     */
    public ProcessComposite(String name, List subprocesses) {
        super(name);
        this.subprocesses = subprocesses;
    }

    /**
     * @return the children of this composite.
     */
    public List getChildren() {
        return subprocesses;
    }

    /**
     * Add the given component as a child.
     * @param c the component to add
     */
    public void add(ProcessComponent c) {
        subprocesses.add(c);
    }

    public ComponentIterator iterator(Set visited) {
        return new CompositeIterator(this, subprocesses, visited);
    }

    /**
     * @return the number of steps (leaf nodes) in the tree that this composite
     *         represents.
     * @param visited components already visited while traversing this component
     */
    public int getStepCount(Set visited) {
        visited.add(getName());
        int count = 0;
        for (int i = 0; i < subprocesses.size(); i++) {
            ProcessComponent pc = (ProcessComponent) subprocesses.get(i);
            if (!visited.contains(pc.getName()))
                    count += pc.getStepCount(visited);
        }
        return count;
    }
}