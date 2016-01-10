package com.oozinoz.simulation;

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

/**
 * Instances of this class simulate rockets. The simulation depends mainly on
 * the internal ballistics of the burning fuel.
 */
public class Skyrocket {
    private double mass;
    private double thrust;
    private double burnTime;
    protected double simTime;

    /**
     * Create a model of a rocket.
     * @param mass the rocket's initial mass
     * @param thrust the rocket's initial thrust
     * @param burnTime the rocket fuel's burn time
     */
    public Skyrocket(double mass, double thrust, double burnTime) {
        this.mass = mass;
        this.thrust = thrust;
        this.burnTime = burnTime;
    }

    /**
     * @return Model mass as reducing linearly from the initial mass down to 0
     *         during the life of the fuel.
     */
    public double getMass() {
        if (simTime > burnTime) return 0;
        return mass * (1 - (simTime / burnTime));
    }

    /**
     * @return Model thrust as constant for the life of the fuel.
     */
    public double getThrust() {
        if (simTime > burnTime) return 0;
        return thrust;
    }

    /**
     * When the simulation updates its clock, hang onto the current time.
     * @param t the time in the simulation
     */
    public void setSimTime(double t) {
        simTime = t;
    }
}