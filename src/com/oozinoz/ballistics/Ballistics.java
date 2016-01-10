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
 * This utility class provides standard equations for burn rate and thrust.
 * 
 * @author Steven J. Metsker
 * 
 * @version 1.0
 */
public class Ballistics {
    private static BallisticsFunction rate;

    private static BallisticsFunction thrust;

    /**
     * @return a standard function that models the burn rate of a rocket's fuel
     *         as function of burn time and the peak time when the burn area
     *         reaches its maximum
     */
    public static BallisticsFunction rate() {
        if (rate == null) {
            rate = new BallisticsFunction() {
                public double function(double t, double tPeak) {
                    return .5 * Math.pow(25, -Math.pow((t - tPeak), 2));
                }
            };
        }
        return rate;
    }

    /**
     * @return a standard function that models the thrust of a rocket engine as
     *         a function of burn time and the peak time when the burn area
     *         reaches its maximum
     */
    public static BallisticsFunction thrust() {
        if (thrust == null) {
            thrust = new BallisticsFunction() {
                public double function(double t, double tPeak) {
                    return 1.7 * Math.pow((rate().function(t, tPeak) / .6),
                            (1 / .3));
                }
            };
        }
        return thrust;
    }
}