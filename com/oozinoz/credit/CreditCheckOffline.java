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

import com.oozinoz.utility.Dollars;

/**
*  Objects of this class check credit using a series of
*  agent/customer dialogs.
*/
public class CreditCheckOffline implements CreditCheck {
    /**
    *  @return the acceptable credit limit for the person
    *  with the supplied identification number.
    *  @param id the customer id
    */
    public Dollars creditLimit(int id) {
        // logic goes here to dialog with call center rep to
        // ascertain a reasonable credit limit
        return new Dollars(0);
    }
}