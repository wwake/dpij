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
*  Record a name that can be used to assign and look up a
*  machine.
*/
public class Variable extends Term {
    protected String name;
    protected Term value;

    /**
    *  Construct a variable with the provided name.
    *  @param name the variable's name
    */
    public Variable(String name) {
        this.name = name;
    }

    /**
    *  @return this variable's name.
    */
    public String getName() {
        return name;
    }

    /**
    *  Set the value of this variable.
    *  @param term the value of this variable
    */
    public void assign(Term term) {
        this.value = term;
    }

    /**
    *  @return true if the provided object equals this one.
    *  @param o an object to compare to
    */
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Variable))
            return false;

        Variable v = (Variable) o;

        return name.equals(v.name);
    }

    /**
    *  @return a hash code for this object.
    */
    public int hashCode() {
        return name.hashCode();
    }

    /**
    *  @return the machine that this variable refers to in
    *  the provided context.
    */
    public Machine eval() {
        return value.eval();
    }

    /**
    *  @return a string description of this variable.
    */
    public String toString() {
        return name + ": " + value;
    }
}