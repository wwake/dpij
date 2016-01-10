package com.oozinoz.credit.ca;

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

import com.oozinoz.credit.ShippingCheck;

/**
 * Instances of this class can check attributes of a shipping address in Canada.
 */
public class ShippingCheckCanada implements ShippingCheck {
    /**
     * @return true if this shipping address incurs a tariff.
     */
    public boolean hasTariff() {
        return true;
    }
}