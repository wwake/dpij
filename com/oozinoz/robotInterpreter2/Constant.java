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

import com.oozinoz.machine.Machine;

/**
*  Represent a specific machine.
*/
public class Constant extends Term {
    protected Machine machine;

    /**
    *  Construct a term that always referst to a specific
    *  machine.
    */
    public Constant(Machine machine) {
        this.machine = machine;
    }

    /**
    *  @return true if the provided object equals this one.
    *  @param obj an object to compare to
    */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj.getClass() == this.getClass()))
            return false;

        Constant that = (Constant) obj;
        return this.machine.equals(that.machine);
    }

    /**
    *  @return a hash code for this object.
    */
    public int hashCode() {
        return machine.hashCode();
    }

    /**
    *  @return the machine that this term wraps.
    */
    public Machine eval() {
        return machine;
    }

    /**
    *  @return a string description of this constant.
    */
    public String toString() {
        return machine.toString();
    }
}