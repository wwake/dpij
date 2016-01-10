package app.interpreter;

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

import com.oozinoz.machine.*;
import com.oozinoz.robotInterpreter2.*;

/**
*  Show the construction and use of a (tiny) interpreter that shuts
*  down all the machines at a particular plant.
*/
class ShowDown {
    public static void main(String[] args) {
        MachineComposite dublin = OozinozFactory.dublin();
        Variable v = new Variable("machine");
        Command c = new ForCommand(dublin, v, new ShutDownCommand(v));
        c.execute();
    }
}