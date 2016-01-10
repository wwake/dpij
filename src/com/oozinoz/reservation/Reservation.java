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

import java.io.Serializable;
import java.util.Date;

import com.oozinoz.utility.Dollars;

/**
 * Objects of this class represent reservations for fireworks displays, but note
 * that this class in not fully developed. The classes in this package show how
 * to use builders to class is just a target for the builders in this package.
 */
public class Reservation implements Serializable {
    private Date date;

    private int headcount;

    private String city;

    private Dollars dollarsPerHead;

    private boolean hasSite;

    /**
     * Construct a reservation with the given parameters. The proper way to
     * construct a reservation is with one of the builders in this package, so
     * this method is private.
     * @param date when to put on a display
     * @param headcount how many people our customer will guarantee to be in
     *            attendance
     * @param city the city (or nearest city) for the display
     * @param dollarsPerHead the price per attendee the customer will pay
     * @param hasSite true, if the customer has a display site in mind
     */
    Reservation(Date date, int headcount, String city, Dollars dollarsPerHead, boolean hasSite) {
        this.date = date;
        this.headcount = headcount;
        this.city = city;
        this.dollarsPerHead = dollarsPerHead;
        this.hasSite = hasSite;
    }

    /**
     * @return a textual description of this reservation.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Date: ");
        sb.append(date.toString());
        sb.append(", Headcount: ");
        sb.append(headcount);
        sb.append(", City: ");
        sb.append(city);
        sb.append(", Dollars/Head: ");
        sb.append(dollarsPerHead);
        sb.append(", Has Site: ");
        sb.append(hasSite);
        return sb.toString();
    }

    /**
     * The scheduled or requested date for the event.
     */
    public Date getDate() {
        return date;
    }

    /**
     * The number of headcount the requester will guarantee.
     */
    public int getHeadcount() {
        return headcount;
    }

    /**
     * @return The nearest city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @return The dollars/head the person will pay.
     */
    public Dollars getDollarsPerHead() {
        return dollarsPerHead;
    }

    /**
     * @return True if the requester has a site in mind for the event.
     */
    public boolean hasSite() {
        return hasSite;
    }
}