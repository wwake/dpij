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
 * Implement the Advisor interface by relying on the Rel8 engine that relates a
 * customer's preferences to other customers' tastes.
 */
public class GroupAdvisor implements Advisor {
    /**
     * @return Recommend a nice item for this customer, based on how this
     *         customer's taste in music and extreme sports correlates with
     *         other customers and with their fireworks preferences.
     * @param c
     *            the customer to cross-sell
     */
    public Firework recommend(Customer c) {
        return (Firework) Rel8.advise(c);
    }
}