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

import com.oozinoz.reservation.BuilderException;
import com.oozinoz.reservation.ForgivingBuilder;
import com.oozinoz.reservation.Reservation;
import com.oozinoz.reservation.ReservationBuilder;
import com.oozinoz.reservation.ReservationParser;
import com.oozinoz.utility.Dollars;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
*  Test that a forgiving builder builds correctly.
*/

public class ForgivingBuilderTest {
    private Locale savedLocale;
    private Date nextNov5;

    @BeforeEach
    public void setUp() {
        // Pick a date definitely in the past: 11-5-2000
        nextNov5 = ReservationBuilder.futurize(new GregorianCalendar(2000, 11 - 1, 5).getTime());
        savedLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    @AfterEach
    public void tearDown() {
        Locale.setDefault(savedLocale);
    }

    /**
    *  Test that we disallow a too low figure for dollars/head.
    */
    @Test
    public void lowDollars() throws ParseException {
        String s = "Date, November 5, Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 1.95, "
                + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);

        assertThrows(BuilderException.class, b::build);
    }

    /**
    *  Test that we disallow a too low figure for headcount.
    */
    @Test
    public void lowHeadCount() throws ParseException {
        String s = "Date, November 5, Headcount, 2, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);

        assertThrows(BuilderException.class, b::build);
    }

    /**
    *  Test that we disallow a missing city.
    */
    @Test
    public void noCity() throws ParseException {
        String s = "Date, November 5, Headcount, 250, "
                + "DollarsPerHead, 9.95, " + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);

        assertThrows(BuilderException.class, b::build);
    }

    /**
    *  Test that we disallow a missing date.
    */
    @Test
    public void noDate() throws ParseException {
        String s = "Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 9.95, "
                + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);

        assertThrows(BuilderException.class, b::build);
    }

    /**
    *  Test that if there is a headcount but no dollars/head value,
    *  set the dollars/head value to be high enough to generate
    *  the minimum take.
    */
    @Test
    public void noDollar() throws BuilderException, ParseException {
        String s = "Date, November 5, Headcount, 250, City, Springfield, "
                + "  HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();

        assertEquals(nextNov5, r.getDate());
        assertEquals(250, r.getHeadcount());
        
        Dollars price = r.getDollarsPerHead().times(r.getHeadcount()); 
        assertFalse(price.isLessThan(ReservationBuilder.MINTOTAL));
        
        assertEquals("Springfield", r.getCity());
        assertFalse(r.hasSite());
    }

    /**
    *  Test that if there is no headcount but there is a dollars/head value,
    *  set the headcount to be at least the minimum attendance and at least
    *  enough to generate enough money for the event.
    */
    @Test
    public void noHeadcount() throws BuilderException, ParseException {
        String s = "Date, November 5,   City, Springfield, "
                + "DollarsPerHead, 9.95, HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        
        assertEquals(nextNov5, r.getDate());
        assertTrue(r.getHeadcount() >= ReservationBuilder.MINHEAD);
        
        Dollars price = r.getDollarsPerHead().times(r.getHeadcount());
        assertFalse(price.isLessThan(ReservationBuilder.MINTOTAL));

        assertEquals("Springfield", r.getCity());
        assertEquals(new Dollars(9.95), r.getDollarsPerHead());
        assertFalse(r.hasSite());
    }

    /**
    *  Test that if the reservation request specifies no headcount and no
    *  dollars/head, set the headcount to the minimum and set dollars/head
    *  to the minimum total divided by the headcount.
    */
    @Test
    public void noHeadcountNoDollar() throws BuilderException, ParseException {
        String s = "Date, November 5,   City, Springfield, "
                + "  HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();

        assertEquals(nextNov5, r.getDate());
        assertEquals(ReservationBuilder.MINHEAD, r.getHeadcount());
        assertEquals("Springfield", r.getCity());

        assertEquals(
                ReservationBuilder.MINTOTAL.dividedBy(r.getHeadcount()),
                r.getDollarsPerHead());
        assertFalse(r.hasSite());       
   }

    /**
    *  Test a normal reservation.
    */
    @Test
    public void normal() throws BuilderException, ParseException {
        String s = "Date, November 5, Headcount, 250, City, Springfield, "
                + "DollarsPerHead, 9.95, HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        
        assertEquals(nextNov5, r.getDate());
        assertEquals(250, r.getHeadcount());
        assertEquals("Springfield", r.getCity());
        assertEquals(new Dollars(9.95), r.getDollarsPerHead());
        assertFalse(r.hasSite());
    }
}