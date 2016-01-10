package com.oozinoz.utility;

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

import com.oozinoz.robotInterpreter.Command;

public class CommandTimer {
    public static long time(Command command) {
        long t1 = System.currentTimeMillis();
        command.execute();
        long t2 = System.currentTimeMillis();
        return t2 - t1;
    }
}
