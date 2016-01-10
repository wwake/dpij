package com.oozinoz.reservation;

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
 * This class builds a valid reservation from its attributes. The
 * <code>build</code> method throws an exception if asked to build in advance
 * of having valid parameters for a reservation.
 */
public class UnforgivingBuilder extends ReservationBuilder {
    /**
     * Create a valid reservation. Throw an exception if any required attribute
     * of a reservation is missing.
     * 
     * @throws BuilderException
     */
    public Reservation build() throws BuilderException {
        if (date == null)
            throw new BuilderException("Valid date not found");

        if (city == null)
            throw new BuilderException("Valid city not found");

        if (headcount < MINHEAD)
            throw new BuilderException("Minimum headcount is " + MINHEAD);

        if (dollarsPerHead.times(headcount).isLessThan(MINTOTAL))
            throw new BuilderException("Minimum total cost is " + MINTOTAL);

        return new Reservation(date, headcount, city, dollarsPerHead, hasSite);
    }
}