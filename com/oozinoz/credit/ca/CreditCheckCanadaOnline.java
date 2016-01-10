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

import com.oozinoz.credit.CreditCheck;
import com.oozinoz.utility.Dollars;

/**
 * Objects of this class check credit by dialing out to a (Canadian) credit
 * service bureau.
 */
public class CreditCheckCanadaOnline implements CreditCheck {
    /**
     * @param id a customer's ID number
     * @return the acceptable credit limit for the person with the supplied
     *         identification number.
     */
    public Dollars creditLimit(int id) {
        // logic goes here to contact a Canadian credit agency
        return new Dollars(0);
    }
}