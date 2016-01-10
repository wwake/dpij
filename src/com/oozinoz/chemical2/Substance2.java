package com.oozinoz.chemical2;

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
 * This class represents a batch of chemical.
 */
public class Substance2 {
    private double grams;

    private Chemical chemical;

    /**
     * Model a batch of stuff, revised from the original Substance class to rely
     * on an (immutable) Chemical class.
     * 
     * @param grams
     *            The mass of this batch of substance.
     * @param chemical
     *            This batch's chemical composition
     */
    public Substance2(double grams, Chemical chemical) {
        this.grams = grams;
        this.chemical = chemical;
    }

    /**
     * @return The name of this substance, such as "Saltpeter."
     */
    public String getName() {
        return chemical.getName();
    }

    /**
     * @return The chemical symbol for this substance, such as "KNO3."
     */
    public String getSymbol() {
        return chemical.getSymbol();
    }

    /**
     * @return The atomic weight of this substance (e.g. 101 for saltpeter).
     */
    public double getAtomicWeight() {
        return chemical.getAtomicWeight();
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
        return grams / getAtomicWeight();
    }
}