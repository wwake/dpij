package app.decorator.brightness;

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

import com.oozinoz.function.Function;

public class Brightness extends Function {
    public Brightness(Function f) {
        super(f);
    }

    public double f(double t) {
        return Math.exp(-4 * sources[0].f(t)) 
             * Math.sin(Math.PI * sources[0].f(t));
    }
}
