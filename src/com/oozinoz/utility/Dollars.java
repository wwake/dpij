package com.oozinoz.utility;

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

public class Dollars {
    public static final Dollars cent = new Dollars(0.01);

    static final int CENTS_PER_DOLLAR = 100;
    
    long cents;

    public Dollars(double value) {
        this.cents = Math.round(value * CENTS_PER_DOLLAR);
    }
    
    public boolean isZero() {
        return cents == 0;
    }

    public Dollars plus(Dollars that) {
        return new Dollars(1.0 * (this.cents + that.cents) / CENTS_PER_DOLLAR);
    }
    
    public Dollars times(int multiplier) {
        return new Dollars((this.cents * multiplier) / CENTS_PER_DOLLAR);
    }

    public Dollars dividedBy(int divisor) {
        double newCents = (1.0 * cents / divisor) / CENTS_PER_DOLLAR;
        return new Dollars(newCents);
    }

    public double dividedBy(Dollars that) {
        return (1.0 * this.cents) / that.cents;
    }

    public boolean isLessThan(Dollars that) {
        return this.cents < that.cents;
    }

    public String toString() {
        StringBuffer result = new StringBuffer("$");

        long dollars = cents / CENTS_PER_DOLLAR;
        result.append(dollars);
        result.append('.');
        
        long pennies = cents % CENTS_PER_DOLLAR;
        if (pennies < 10) result.append('0');
        result.append(pennies);

        return result.toString();
    }

    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass()))
            return false;
        Dollars that = (Dollars) obj;
        return this.cents == that.cents;
    }

    public int hashCode() {
        return (int) cents;
    }

    public long asCents() {
        return cents;
    }
}