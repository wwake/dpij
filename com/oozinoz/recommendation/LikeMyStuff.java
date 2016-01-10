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
 * that relies on customer purchasing history for its suggestions.
 */
public class LikeMyStuff {
    /**
     * @return Recommend a nice item for this customer, based on his or her
     *         previous purchases.
     * @param c the customer
     */
    public static Object suggest(Customer c) {
        return new Firework();
    }
}