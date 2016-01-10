package app.command;

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
import com.oozinoz.utility.CommandTimer;

import junit.framework.TestCase;

public class TestCommandTimer extends TestCase {
    public void testSleep() {
        Command doze = new Command() {
            public void execute() {
                try {
                    Thread.sleep(2000 + Math.round(10 * Math.random()));
                } catch (InterruptedException ignored) {
                }
            }
        };

        long actual = CommandTimer.time(doze);

        long expected = 2000;
        long delta = 5;
        assertTrue("Should be " + expected + " +/- " + delta + " ms", 
                expected - delta <= actual
             && actual <= expected + delta);
    }
}