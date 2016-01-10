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

import java.util.Properties;

import com.oozinoz.firework.Firework;

/**
 * Implement the Advisor interface, recommending a currently promoted firework.
 * 
 * @author Steven J. Metsker
 */
public class PromotionAdvisor implements Advisor {
    private Firework promoted;

    public PromotionAdvisor() {
        try {
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResourceAsStream("config/strategy.dat"));
            String promotedFireworkName = p.getProperty("promote");
            if (promotedFireworkName != null) 
                promoted = Firework.lookup(promotedFireworkName);
        } catch (Exception ignored) {
            // Resource not found or failed to load
            promoted = null;
        }
    }

    /**
     * @return true if the constructor was able to find a promoted firework.
     */
    public boolean hasItem() {
        return promoted != null;
    }

    /**
     * Recommend a nice item for this customer, based what we're promoting.
     * 
     * @param Customer
     *            the customer to cross-sell
     * @return a nice item for the customer to buy
     */
    public Firework recommend(Customer c) {
        return promoted;
    }
}