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

import com.oozinoz.utility.Dollars;

public class DollarsTest extends TestCase {
    public void testZero() {
        Dollars d = new Dollars(0);
        assertTrue(d.isZero());
    }

    public void testCents() {
        Dollars d = new Dollars(0.17);
        assertFalse(d.isZero());
        assertEquals(17, d.asCents());
        assertEquals("$0.17", d.toString());
    }

    public void testDouble() {
        Dollars d = new Dollars(0.10);
        assertFalse(d.isZero());
        assertEquals(10, d.asCents());
        assertEquals("$0.10", d.toString());
    }

    public void testEquals() {
        Dollars d1 = new Dollars(3.17);
        Dollars d2 = new Dollars(3.17);
        Dollars d3 = new Dollars(3.16);
        
        assertTrue(d1.equals(d2));
        assertTrue(d2.equals(d1));
        assertEquals(d1, d2);
        
        assertFalse(d2.equals(d3));
        assertFalse(d3.equals(d2));
        assertFalse(d1.equals(new Object()));        
    }
    
    public void testPlus() {
        Dollars d1 = new Dollars(1.27);
        Dollars d2 = new Dollars(2.35);
        assertEquals(new Dollars(3.62), d1.plus(d2));
    }
    
    public void testTimes() {
        Dollars d1 = new Dollars(1.95);
        assertEquals(195, d1.asCents());
        Dollars d2 = d1.times(100);
        assertEquals(new Dollars(195.00), d2);
    }
    
    public void testDividedByDollars() {
        Dollars d1 = new Dollars(11.00);
        Dollars d2 = new Dollars(5);
        assertEquals(2.2, d1.dividedBy(d2), 0.001);
        assertEquals(0.4545, d2.dividedBy(d1), 0.001);
    }
    
    public void testDividedByInt() {
        Dollars d1 = new Dollars(1.00);
        assertEquals(new Dollars(0.33), d1.dividedBy(3));
    }
}