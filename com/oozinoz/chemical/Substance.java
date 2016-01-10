package com.oozinoz.chemical;

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
 * This class represents a batch of chemicals.
 */
public class Substance {
    private String name;

    private String symbol;

    private double atomicWeight;

    private double grams;

    /**
     * Model a batch of stuff.
     * 
     * @param name
     *            The name of this substance, such as "Saltpeter."
     * @param symbol
     *            The chemical symbol for this substance, such as "KNO3."
     * @param atomicWeight
     *            The atomic weight of this substance (101 for saltpeter).
     * @param grams
     *            The mass of this batch of substance.
     */
    public Substance(String name, String symbol, double atomicWeight,
            double grams) {
        this.name = name;
        this.symbol = symbol;
        this.atomicWeight = atomicWeight;
        this.grams = grams;
    }

    /**
     * @return The name of this substance, such as "Saltpeter."
     */
    public String getName() {
        return name;
    }

    /**
     * @return The chemical symbol for this substance, such as "KNO3."
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return The atomic weight of this substance (e.g. 101 for saltpeter).
     */
    public double getAtomicWeight() {
        return atomicWeight;
    }

    /**
     * @return The mass of this batch of substance.
     */
    public double getGrams() {
        return grams;
    }

    /**
     * @return The number of moles in this batch.
     */
    public double getMoles() {
        return grams / atomicWeight;
    }
}