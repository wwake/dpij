package com.oozinoz.robotInterpreter2;

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

import java.util.List;

import com.oozinoz.machine.Machine;
import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.MachineComposite;

/**
 * This class represents a "for" loop that will execute its body for each
 * machine in a provided composite, assigning a variable to a different machine
 * in each pass through the loop.
 */
public class ForCommand extends Command {
    protected MachineComponent root;
    protected Variable variable;
    protected Command body;

    /**
     * Construct a "for" interpreter that will execute the provided body,
     * looping through the machines in a context, assigning the provided
     * variable to each machine.
     * @param root The machine component over which to iterate
     * @param v the variable to set for each loop
     * @param body the body of the for command
     */
    public ForCommand(MachineComponent mc, Variable v, Command body) {
        this.root = mc;
        this.variable = v;
        this.body = body;
    }

    /**
     * For each machine in the context, assign this object's variable to the
     * machine, and execute this object's body.
     */
    public void execute() {
        execute(root);
    }

    private void execute(MachineComponent mc) {
        if (mc instanceof Machine) {
            Machine m = (Machine) mc;
            variable.assign(new Constant(m));
            body.execute();
            return;
        }

        MachineComposite comp = (MachineComposite) mc;
        List children = comp.getComponents();
        for (int i = 0; i < children.size(); i++) {
            MachineComponent child = (MachineComponent) children.get(i);
            execute(child);
        }
    }
}