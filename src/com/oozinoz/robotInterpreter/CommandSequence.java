package com.oozinoz.robotInterpreter;

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

/**
*  This class contains a sequence of other commands.
*/
public class CommandSequence extends Command {
    protected List commands = new ArrayList();

    /**
    *  Add a command to the sequence of commands to which this
    *  object will cascade an Execute() command.
    *  @param c a command to add
    */
    public void add(Command c) {
        commands.add(c);
    }

    /**
    *  @returns a string description of this command sequence.
    */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        boolean needLine = false;

        for (int i = 0; i < commands.size(); i++) {
            Command c = (Command) commands.get(i);
            if (needLine)
                sb.append("\n");

            sb.append(c);
            needLine = true;
        }

        return sb.toString();
    }

    /**
    *  Ask each command in the sequence to execute.
    */
    public void execute() {
        for (int i = 0; i < commands.size(); i++) {
            Command c = (Command) commands.get(i);
            c.execute();
        }
    }
}