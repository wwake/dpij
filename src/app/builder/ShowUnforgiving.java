package app.builder;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker. Steve Metsker makes no
 * representations or warranties about the fitness of this software for any
 * particular purpose, including the implied warranty of merchantability. Please
 * use this software as you wish with the sole restriction that you may not
 * claim that you wrote it.
 */

import com.oozinoz.reservation.*;

public class ShowUnforgiving {
    public static void main(String[] args) {
        /* Remove "DollarsPerHead, 9.95" to see exception message when that field is omitted. */
        String sample = "Date, November 5, Headcount, 250, "
                + "City, Springfield, DollarsPerHead, 9.95, HasSite, False";
        ReservationBuilder builder = new UnforgivingBuilder();
        try {
            new ReservationParser(builder).parse(sample);
            Reservation res = builder.build();
            System.out.println("Unforgiving builder: " + res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
