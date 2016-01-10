package com.oozinoz.testing;

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

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import junit.framework.TestCase;

import com.oozinoz.reservation.BuilderException;
import com.oozinoz.reservation.Reservation;
import com.oozinoz.reservation.ReservationBuilder;
import com.oozinoz.reservation.ReservationParser;
import com.oozinoz.reservation.UnforgivingBuilder;
import com.oozinoz.utility.Dollars;

public class UnforgivingBuilderTest extends TestCase {
    Locale savedLocale;
    Date nextNov5;
    
    public void setUp() {
        // Pick a date definitely in the past: 11-5-2000
        nextNov5 = ReservationBuilder.futurize(new GregorianCalendar(2000, 11 - 1, 5).getTime());
        savedLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    public void tearDown() {
        Locale.setDefault(savedLocale);
    }

    public void testDisallowLowDollarsPerHead() throws ParseException {
        String sample = "Date, November 5, Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 1.95, "
                + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(sample);

        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {
        }
    }

    public void testDisallowLowHeadCount() throws ParseException {
        String s = "Date, November 5, Headcount, 2, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {
        }
    }

    public void testDisallowNoDollars() throws ParseException {
        String sample = "Date, November 5, Headcount, 250, "
                + "City, Springfield, " + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(sample);
        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {
        }
    }

    public void testDisallowNoHeadCount() throws ParseException {
        String s = "Date, November 5, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {
        }
    }

    public void testNormalReservation() throws BuilderException, ParseException {
        String s = "Date, November 5, Headcount, 250, City, Springfield, "
                + "DollarsPerHead, 9.95, HasSite, false";
        UnforgivingBuilder b = new UnforgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();

        assertEquals(nextNov5, r.getDate());
        assertEquals(250, r.getHeadcount());
        assertEquals("Springfield", r.getCity());
        assertEquals(new Dollars(9.95), r.getDollarsPerHead());
        assertFalse(r.hasSite());
    }

    public void testDisallowMissingCity() throws ParseException {
        String s = "Date, November 5, Headcount, 250, "
                + "DollarsPerHead, 9.95, " + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("BuilderException expected: built " + r);
        } catch (BuilderException expected) {
        }
    }

    public void testDisallowMissingDate() throws ParseException {
        String s = "Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("BuilderException expected: built " + r);
        } catch (BuilderException expected) {
        }
    }
}