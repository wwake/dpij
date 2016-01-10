package com.oozinoz.recommendation;

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

import com.oozinoz.firework.Firework;

/**
 * This class is just a mock-up, acting as if it were a recommendation engine
 * that relies on customer profiling for its suggestions.
 */
public class Rel8 {
    /**
     * Recommend a nice item for this customer, based on how this customer's
     * taste in music and extreme sports correlates with other customers and
     * with their fireworks preferences.
     * @param c the customer
     * @return a suggested firework
     */
    public static Object advise(Customer c) {
        return new Firework();
    }
}