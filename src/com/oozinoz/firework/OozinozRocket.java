package com.oozinoz.firework;

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

import com.oozinoz.simulation.*;

/**
*  An adapter that lets a rocket participate in a simulation.
*/
public class OozinozRocket extends PhysicalRocket implements RocketSim {
    private double time;

    public OozinozRocket(
            double burnArea, 
            double burnRate, 
            double fuelMass,
            double totalMass) {
        super(burnArea, burnRate, fuelMass, totalMass);
    }

    public double getMass() {
        return getMass(time);
    }

    public double getThrust() {
        return getThrust(time);
    }

    public void setSimTime(double time) {
        this.time = time;
    }
}