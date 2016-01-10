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

/**
*  This class represents a "while" statement that will execute
*  its body so long as its term evaluates to a non-null value.
*/
public class WhileCommand extends Command {
    protected Term term;

    protected Command body;

    /**
    *  Construct a "while" command that will execute its body
    *  as long as the supplied term evaulates to a non-null value.
    *  @param term the term to evaluate on each loop of the while
    *  @param body the body to execute
    */
    public WhileCommand(Term term, Command body) {
        this.term = term;
        this.body = body; 
    }

    /**
    *  Evaluate this object's term; if it's not null,
    *  execute the body. Repeat.
    */
    public void execute() {
        while (term.eval() != null)
            body.execute();
    }
}