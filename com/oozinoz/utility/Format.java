package com.oozinoz.utility;

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

import java.text.NumberFormat;

public class Format {
    private static NumberFormat numberFormatter = NumberFormat.getInstance();
    
    public static String formatToNPlaces(double d, int numberOfFractionDigits) {
        numberFormatter.setMinimumFractionDigits(numberOfFractionDigits);
        numberFormatter.setMaximumFractionDigits(numberOfFractionDigits);
        return numberFormatter.format(d);
    }
}
