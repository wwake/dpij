package com.oozinoz.remote;

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

import java.rmi.*;

/**
 * This interface defines what makes up a rocket, but note that this entire
 * package is exploratory and not yet integrated into the mainstream oozinoz
 * packages.
 * @author Steve Metsker
 */
public interface Rocket extends Remote {
    /**
     * Set a factor to adjust a particular rocket's apogee.
     * @param factor the factor
     */
    void boost(double factor) throws RemoteException;

    /**
     * Return the expected height this rocket will reach.
     * @return the expected height this rocket will reach
     */
    double getApogee() throws RemoteException;

    /**
     * Return the price of this rocket.
     * @return the price of this rocket
     */
    double getPrice() throws RemoteException;
}