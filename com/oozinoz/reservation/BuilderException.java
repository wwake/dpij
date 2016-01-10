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
*  Signals a problem while building a reservation from its
*  attributes.
*/
public class BuilderException extends Exception {
    /**
    *  Constructs a BuilderException with no detail
    *  message.
    */
    public BuilderException() {
    }

    /**
    *  Constructs a BuilderException with the
    *  specified detail message.
    *  @param s detail message
    */
    public BuilderException(String s) {
        super(s);
    }
}