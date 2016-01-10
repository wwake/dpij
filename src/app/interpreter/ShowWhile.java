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
 * Show the use of a "while" interpreter.
 */
public class ShowWhile {
    public static void main(String[] args) {
        MachineComposite dublin = OozinozFactory.dublin();
        Term starPress = new Constant((Machine) dublin.find("StarPress:1401"));
        Term fuser = new Constant((Machine) dublin.find("Fuser:1101"));
        
        starPress.eval().load(new Bin(77));
        starPress.eval().load(new Bin(88));
        
        WhileCommand command = new WhileCommand(
            new HasMaterial(starPress),
            new CarryCommand(starPress, fuser));
        command.execute();
    }
}