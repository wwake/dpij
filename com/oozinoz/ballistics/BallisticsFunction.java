package com.oozinoz.ballistics;

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
 * This interface just defines a generic "function" method that implementors
 * fill in with a ballistics function. Typically the name of the function will
 * appear as the name of the implementing class, such as BurnRate or Thrust.
 */
public interface BallisticsFunction {
    /**
     * Implementors provide some function that depends on the ballistics
     * parameters of burn time and peak time.
     * 
     * @return double
     */
    double function(double t, double tPeak);
}