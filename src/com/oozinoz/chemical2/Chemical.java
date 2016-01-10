package com.oozinoz.chemical2;

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
*  Part of the Flyweight chapter, this interface is related to 
*  restricting the ability to create flyweights.
*/
public interface Chemical
{
    String getName();
    String getSymbol();
    double getAtomicWeight();
}