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
 * Implement the Advisor interface by relying on the LikeMyStuff engine that
 * models a customer's preferences on his or her eariler purchases.
 */
public class ItemAdvisor implements Advisor {
    /**
     * @return Recommend a nice item for this customer, based on a model of the
     *         customer's recent spending with us.
     * @param c the customer to cross-sell
     */
    public Firework recommend(Customer c) {
        return (Firework) LikeMyStuff.suggest(c);
    }
}