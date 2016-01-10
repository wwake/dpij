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

import com.oozinoz.utility.Dollars;

/**
 * Objects of this class represent types of fireworks.
 */
public class Firework {
    /**
     * @return a firework of the given name. This method supports a "Strategy"
     *         example, but it isn't really implemented.
     * @param name
     *            a name to lookup
     */
    public static Firework lookup(String name) {
        return new Firework(name, 9.0, new Dollars(3));
    }

    /**
     * @return a random firework from our shelves. This method is not actually
     *         implemented -- it's here as part of a "Strategy" example.
     */
    public static Firework getRandom() {
        return new Firework("Random firework", 10.0, new Dollars(15));
    }

    
    private String name;
    private double mass;
    private Dollars price;

    /**
     * Allow creation of empty objects to support reconstruction from persistent
     * store.
     */
    public Firework() {
    }

    /**
     * Create a firework, providing all of its properties.
     * 
     * @param name
     *            The unique name of this type of firework
     * @param mass
     *            The mass, in kilograms, of one instance of this type
     * @param price
     *            The price (in dollars) of one instance of this type
     */
    public Firework(String name, double mass, Dollars price) {
        setName(name);
        setMass(mass);
        setPrice(price);
    }

    /**
     * The unique name of this type of firework
     */
    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    /**
     * The mass, in kilograms, of one instance of this type
     */
    public double getMass() {
        return mass;
    }

    public void setMass(double value) {
        mass = value;
    }

    /**
     * The price (in dollars) of one instance of this type
     */
    public Dollars getPrice() {
        return price;
    }

    public void setPrice(Dollars value) {
        price = value;
    }

    /**
     * @return a textual representation of this firework.
     */
    public String toString() {
        return getName();
    }
}