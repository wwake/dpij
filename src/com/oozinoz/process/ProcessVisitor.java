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

/**
*  This interface defines the type of object that process
*  steps and process composites will accept. The
*  ProcessComponent hierarchy classes call back a Visiting
*  object's visit() methods; In so doing they identify their
*  type. Implementors of this interface can create algorithms
*  that operate differently on different type of process
*  components.
*/
public interface ProcessVisitor {
    /**
    *  Visit a process alternation.
    *  @param a the process alternation to visit
    */
    void visit(ProcessAlternation a);

    /**
    *  Visit a process sequence.
    *  @param s the process sequence to visit
    */
    void visit(ProcessSequence s);

    /**
    *  Visit a process step.
    *  @param s the process step to visit
    */
    void visit(ProcessStep s);
}