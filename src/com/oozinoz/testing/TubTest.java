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

import junit.framework.TestCase;

import com.oozinoz.machine.*;

/**
*  Test Machine/Tub relationships.
*/

public class TubTest extends TestCase {
    public void testAddTub() {
        TubMediator mediator = new TubMediator();
        Tub tub = new Tub("T402", mediator);
        Machine m1 = new Fuser(1, mediator);
        Machine m2 = new Fuser(2, mediator);
        
        // place the tub on m1
        tub.setLocation(m1);
        assertEquals(1, m1.getTubs().size());
        
        // move the tub by adding it to m2
        m2.addTub(tub);
        assertEquals(m2, tub.getLocation());
        assertEquals(0, m1.getTubs().size());
        assertEquals(1, m2.getTubs().size());
    }

    public void testLocationChange() {
        TubMediator mediator = new TubMediator();
        Tub t = new Tub("T403", mediator);
        Machine m1 = new Fuser(1001, mediator);
        Machine m2 = new Fuser(1002, mediator);

        t.setLocation(m1);
        assertTrue(m1.getTubs().contains(t));
        assertTrue(!m2.getTubs().contains(t));

        t.setLocation(m2);
        assertFalse(m1.getTubs().contains(t));
        assertTrue(m2.getTubs().contains(t));
    }
}