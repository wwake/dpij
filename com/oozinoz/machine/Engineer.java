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
 * This isn't much of a model, but it provides a data type that represents the
 * role of a person that can be responsible for a machine.
 */
public class Engineer {
    protected int employeeID;

    /**
     * Model an engineer with the given employee id.
     * @param employeeID The employee id for the engineer
     */
    public Engineer(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return This engineer's employee ID.
     */
    public int getEmployeeID() {
        return employeeID;
    }
}