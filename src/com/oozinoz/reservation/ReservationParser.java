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

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.oozinoz.utility.Dollars;

/**
 * This class parses a request for a fireworks exhibition. The request must be a
 * comma-separated list of parameter names and values. The expected parameters
 * for an exhibition are: date, heacount, city, dollarsPerHead, and hasSite. For
 * example, a valid request is: <blockquote>
 * 
 * <pre>
 *       Date, November 5, Headcount, 250, City, Springfield,
 *       DollarsPerHead, 9.95, HasSite, No            
 * </pre>
 * 
 * </blockquote> The format for dates is the name of the month followed by the
 * day. This parser assumes the year for the date is the year in which the date
 * next occurs.
 */
public class ReservationParser {
    private ReservationBuilder builder;

    /**
     * Create a parser that will pass its results to the specified builder.
     * @param builder the builder to pass parameters to
     */
    public ReservationParser(ReservationBuilder builder) {
        this.builder = builder;
    }

    /**
     * Parse a reservation request, passing its information to the builder.
     * @param s the request
     */
    public void parse(String s) throws ParseException {
        String[] tokens = s.split(",\\s*");
        for (int i = 0; i < tokens.length; i += 2) {
            String type = tokens[i];
            String val = tokens[i + 1];

            if ("date".compareToIgnoreCase(type) == 0) {
                Calendar now = Calendar.getInstance();
                DateFormat formatter = DateFormat.getDateInstance();
                Date d = formatter.parse(val + ", " + now.get(Calendar.YEAR));
                builder.setDate(ReservationBuilder.futurize(d));
            } else if ("headcount".compareToIgnoreCase(type) == 0) 
                builder.setHeadcount(Integer.parseInt(val));
            else if ("City".compareToIgnoreCase(type) == 0)
                builder.setCity(val.trim());
            else if ("DollarsPerHead".compareToIgnoreCase(type) == 0) 
                builder.setDollarsPerHead(new Dollars(Double.parseDouble(val)));
            else if ("HasSite".compareToIgnoreCase(type) == 0)
                builder.setHasSite(val.equalsIgnoreCase("true"));
        }
    }
}