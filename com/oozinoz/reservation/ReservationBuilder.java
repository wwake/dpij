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

import java.util.*;

import com.oozinoz.utility.Dollars;

/**
*  Subclasses of this abstract class validate a reservation's
*  attributes before constructing a Reservation object.
*/
public abstract class ReservationBuilder {
    public static final int MINHEAD = 25;

    public static final Dollars MINTOTAL = new Dollars(495.95);

    protected Date date = null;

    protected String city;

    protected int headcount;

    protected Dollars dollarsPerHead = new Dollars(0);

    protected boolean hasSite;

    /**
    *  Push a date into the future by rolling forward the year.
    *  @param inDate a date to push forward
    *  @return a date like the one provided but with a year
    *  that makes the date in the future
    */
    public static Date futurize(Date inDate) {
        Calendar now = Calendar.getInstance();
        Calendar then = Calendar.getInstance();
        then.setTime(inDate);
        
        while (then.before(now)) 
            then.add(Calendar.YEAR, 1);
        
        return then.getTime();
    }

    /**
    *  Construct a valid reservation from attributes that have
    *  been presumably been set for this builder. Subclasses may
    *  throw an exception if a valid reservation cannot
    *  be formed.
    * @return a valid reservation
    */
    public abstract Reservation build() throws BuilderException;

    /**
    *  The city for a reservation
    */
    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        city = value;
    }

    /**
    *  The date for a reservation.
    */
    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        date = value;
    }

    /**
    *  The dollars/head that a customer will pay for a display.
    */
    public Dollars getDollarsPerHead() {
        return dollarsPerHead;
    }

    public void setDollarsPerHead(Dollars value) {
        dollarsPerHead = value;
    }

    /**
    *  Indicates whether a customer has a site in mind for a
    *  display.
    */
    public boolean hasSite() {
        return hasSite;
    }

    public void setHasSite(boolean value) {
        hasSite = value;
    }

    /**
    *  The number of people that a customer will guarantee for
    *  a display.
    */
    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int value) {
        headcount = value;
    }
}