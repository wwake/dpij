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

import com.oozinoz.function.Arithmetic;
import com.oozinoz.function.Constant;
import com.oozinoz.function.Function;
import com.oozinoz.function.Scale;

/**
*  A few tests of Function wrappers.
*/
public class FunctionTest extends TestCase {
    double fuzz = 0.00001;

    public void testConstant() {
        Constant c = new Constant(42);
        assertEquals(42, c.f(0), fuzz);
        assertEquals(42, c.f(0.5), fuzz);
        assertEquals(42, c.f(1), fuzz);
    }

    public void testScale() {
        Function c = new Scale(0, 100); // let Celsius go 0 to 100
        Function f = new Scale(new Constant(0), c, new Constant(100),
                new Constant(32), new Constant(212));

        assertEquals(32.0, f.f(0), fuzz);
        assertEquals(-40, f.f(-0.4), fuzz);
        assertEquals(212, f.f(1), fuzz);
    }

    public void testArithmetic() {
        Function f = new Arithmetic('+', new Constant(3), new Constant(4));
        assertEquals(7, f.f(0), fuzz);
        assertEquals(7, f.f(0.5), fuzz);
        assertEquals(7, f.f(1), fuzz);
    }
}