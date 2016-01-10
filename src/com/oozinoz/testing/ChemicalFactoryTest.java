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
import com.oozinoz.chemical.ChemicalFactory;
import com.oozinoz.chemical2.ChemicalFactory2;

public class ChemicalFactoryTest extends TestCase {
    public void testGetFactory() {
        assertEquals("Carbon(C)[12.0]", ChemicalFactory.getChemical("CARBON").toString());
    }
    
    public void testChemicalFactory2() {
        assertEquals("Carbon(C)[12.0]", ChemicalFactory2.getChemical("CARBON").toString());
    }
}
