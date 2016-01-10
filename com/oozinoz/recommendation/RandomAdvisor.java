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
 * Implement the Advisor interface, recommending a random firework.
 */
public class RandomAdvisor implements Advisor {
    /**
     * @param c the customer
     * @return any firework, chosen at random
     */
    public Firework recommend(Customer c) {
        return Firework.getRandom();
    }
}