package app.visitor;

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

import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.OozinozFactory;

/**
 * Show the use of the FindVisitor class.
 * 
 * @author Steven J. Metsker
 * @see com.oozinoz.dublin.FindVisitor
 */
public class ShowFindVisitor {
    public static void main(String[] args) {
        MachineComponent factory = OozinozFactory.dublin();
        MachineComponent machine = new FindVisitor().find(factory, 3404);
        System.out.println(machine != null ? machine.toString() : "Not found");
    }
}