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

import com.oozinoz.credit.*;

/**
 * This factory supplies objects that can check credit, billing addresses, and
 * shipping addresses in Canada.
 */
public class CheckFactoryCanada extends CreditCheckFactory {
    /**
     * @return a BillingCheck object for Canadian customers.
     */
    public BillingCheck createBillingCheck() {
        return new BillingCheckCanada();
    }

    /**
     * @return an ICreditCheck object for Canadian customers.
     */
    public CreditCheck createCreditCheck2() {
        if (isAgencyUp())
            return new CreditCheckCanadaOnline();
        return new CreditCheckOffline();
    }

    /**
     * @return a ShippingCheck object for Canadian customers.
     */
    public ShippingCheck createShippingCheck() {
        return new ShippingCheckCanada();
    }
}