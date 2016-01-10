package com.oozinoz.firework;

import com.oozinoz.utility.Dollars;

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
 * A wire coated with a combustible paste saturated with iron filings that,
 * well, sparkle when ignited.
 * @author Steven J. Metsker
 */
public class Sparkler extends Firework {
    /**
     * Make a sparkler.
     * @param String the sparkler's name, understanding that it's hard to get
     *            really exotic when naming a sparkler
     * @param double the price
     */
    public Sparkler(String name, Dollars price) {
        super(name, 0.01, price);
    }
}