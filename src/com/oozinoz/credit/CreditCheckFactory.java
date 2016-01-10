package com.oozinoz.credit;

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
 * This factory produces objects that can check credit.
 */
public abstract class CreditCheckFactory {
    /**
     * @return a CreditCheck object; the actual class of the object depends on
     *         whether the credit agency is up.
     */
    public static CreditCheck createCreditCheck() {
        if (isAgencyUp())
            return new CreditCheckOnline();

        return new CreditCheckOffline();
    }

    /**
     * @return true if the service bureau is accessible. This method is not yet
     *         actually implemented.
     */
    public static boolean isAgencyUp() {
        return true;
    }

    /**
     * @return a BillingCheck object; the actual class of the object depends
     *         on subclasses.
     */
    public abstract BillingCheck createBillingCheck();

    /**
     * @return a CreditCheck object; the actual class of the object depends on
     *         subclasses.
     */
    public abstract CreditCheck createCreditCheck2();

    /**
     * @return a ShippingCheck object; the actual class of the object depends
     *         on subclasses.
     */
    public abstract ShippingCheck createShippingCheck();
}