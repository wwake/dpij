package app.construction;

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

import java.awt.Point;
import java.lang.reflect.Constructor;

public class ShowReflection {

    public static void main(String[] args) {
        Constructor<?>[] cc = Point.class.getConstructors();

        Constructor<?> cons = null;
        for (Constructor<?> aCc : cc)
            if (aCc.getParameterTypes().length == 2) {
                cons = aCc;
            }

        try {
            Object obj = cons.newInstance(3, 4);

            System.out.println(obj);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}