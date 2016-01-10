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

import com.oozinoz.firework.OozinozSkyrocket;
import com.oozinoz.firework.PhysicalRocket;

/**
*  Test the Simulation package and the Fireworks classes that support it.
*/

public class SkyrocketTest extends TestCase
{
    private static double SPECIFIC_IMPULSE = 620; // Newtons/Kg
    private static double FUEL_DENSITY = 1800; // Kg/M**3

    /**
    *  Test that mass varies linearly from start mass to 0, over the
    *  time it takes the fuel to burn.
    */
    public void testPhysicalRocket() 
    {
        double burnArea = .0030;
        double burnDepth = .06;
        double burnVolume = burnArea * burnDepth;
        double fuelMass = burnVolume * FUEL_DENSITY;
        double totalMass = fuelMass * 1.1;
        double burnRate = .020;

        PhysicalRocket r = new PhysicalRocket(burnArea, burnRate, fuelMass, totalMass);

        double bt = burnDepth / burnRate;
        double tol = 0.01;
        assertEquals("check burn time", bt, r.getBurnTime(), tol);

        assertEquals("initial mass", totalMass, r.getMass(0), tol);
        assertEquals("burnt out mass", totalMass - fuelMass, r.getMass(bt), tol);
        assertEquals("half mass", totalMass - fuelMass * .5, r.getMass(bt/2), tol);
        assertEquals("thrust", SPECIFIC_IMPULSE * FUEL_DENSITY * burnArea * burnRate, r.getThrust(bt/2), tol);
    }           
    
    /**
    *  Test that mass varies linearly from start mass to 0, over the
    *  time it takes the fuel to burn.
    */
    public void testOozinozSkyocket() 
    {
        double burnArea = .0030;
        double burnDepth = .06;
        double burnVolume = burnArea * burnDepth;
        double fuelMass = burnVolume * FUEL_DENSITY;
        double totalMass = fuelMass * 1.1;
        double burnRate = .020;

        PhysicalRocket pr = new PhysicalRocket(burnArea, burnRate, fuelMass, totalMass);

        OozinozSkyrocket or = new OozinozSkyrocket(pr);

        double tol = 0.01;

        or.setSimTime(0);    
        assertEquals("initial mass", totalMass, or.getMass(), tol);
        assertEquals("thrust", SPECIFIC_IMPULSE * FUEL_DENSITY * burnArea * burnRate, or.getThrust(), tol);
        
        double bt = burnDepth / burnRate;
        or.setSimTime(bt * 1.01); 
        assertEquals("end mass", totalMass - fuelMass, or.getMass(), tol);
        assertEquals("thrust", 0, or.getThrust(), tol);
    }      
}