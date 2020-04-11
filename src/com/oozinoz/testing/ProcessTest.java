package com.oozinoz.testing;

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

import com.oozinoz.process.ProcessComponent;
import com.oozinoz.process.ProcessSequence;
import com.oozinoz.process.ProcessStep;
import com.oozinoz.process.ShellProcess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
*  Test the ProcessComponent hierarchy, especially its ability
*  to model cyclic processes.
*/

public class ProcessTest {
    /**
    *  @return a tiny process flow that shows a composite that is
    *  not a tree (but also not a cycle, by the way). In this flow
    *  A contains C and B, B contains C.
    */
    public static ProcessComponent abc() {
        ProcessSequence a = new ProcessSequence("a");
        ProcessSequence b = new ProcessSequence("b");
        ProcessStep c = new ProcessStep("c");
        a.add(c);
        a.add(b);
        b.add(c);
        return a;
    }

    /**
    *  @return a tiny process flow that shows a composite that is
    *  not a tree. In this flow A contains B, B contains C,
    *  and C contains A.
    */
    public static ProcessComponent cycle() {
        ProcessSequence a = new ProcessSequence("a");
        ProcessSequence b = new ProcessSequence("b");
        ProcessSequence c = new ProcessSequence("c");
        a.add(b);
        b.add(c);
        c.add(a);
        return a;
    }

    @Test
    public void countOfCycle() {
        assertEquals(0, cycle().getStepCount());
    }

    @Test
    public void stepCountForEmptyProcess() {
        ProcessSequence nil = new ProcessSequence("nil");
        assertEquals(0, nil.getStepCount());        
    }

    @Test
    public void stepCountForOneStepProcess() {
        ProcessStep uno = new ProcessStep("uno");
        assertEquals(1, uno.getStepCount());
    }

    @Test
    public void shampooProcess_ShampooRinseRepeat() {
        ProcessStep shampoo = new ProcessStep("shampoo");
        ProcessStep rinse = new ProcessStep("rinse");
        ProcessSequence once = new ProcessSequence("once");
        once.add(shampoo);
        once.add(rinse);
        ProcessSequence instructions = new ProcessSequence("instructions");
        instructions.add(once);
        instructions.add(once);
        assertEquals(2, instructions.getStepCount());
    }

    @Test
    public void stepCountForAerialShellProcess() {
        assertEquals(4, ShellProcess.make().getStepCount());
    }

    @Test
    public void stepCountForNonTreeDirectedAcyclicGraph() {
        assertEquals(1, abc().getStepCount());
    }

    //
    //   abc
    //  / \
    // a   bc
    //     / \
    //    b   c
    //
    @Test
    public void simpleTree() {
        ProcessStep a = new ProcessStep("a");
        ProcessStep b = new ProcessStep("b");
        ProcessStep c = new ProcessStep("c");
        ProcessSequence bc = new ProcessSequence("bc");
        bc.add(b);
        bc.add(c);
        ProcessSequence abc = new ProcessSequence("abc");
        abc.add(a);
        abc.add(bc);
        assertEquals(3, abc.getStepCount());
    }
}