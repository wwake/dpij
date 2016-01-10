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
 * Instances of this class qualify as Skyrocket objects, but use information
 * from a PhysicalRocket object. This class is an "object adapter" that adapts
 * the PhysicalRocket class to meet the needs of clients of the Skyrocket class.
 */
public class OozinozSkyrocket extends Skyrocket {
    private PhysicalRocket rocket;

    public OozinozSkyrocket(PhysicalRocket r) {
        super(r.getMass(0), r.getThrust(0), r.getBurnTime());
        rocket = r;
    }

    /**
     * Use a PhysicalRocket object to model a rocket's mass at simulation time.
     * @return mass
     */
    public double getMass() {
        return rocket.getMass(simTime);
    }

    /**
     * Use a PhysicalRocket object to model a rocket's thrust at simulation
     * time.
     * @return thrust
     */
    public double getThrust() {
        return rocket.getThrust(simTime);
    }
}