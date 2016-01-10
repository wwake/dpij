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
 * Show how a program on one machine can interact with an object on another
 * machine.
 * @author Steven J. Metsker
 */
public class ShowRocketClient {
    /**
     * Show how a program on one machine can interact with an object on another
     * machine.
     */
    public static void main(String[] args) {
        try {
            Object obj = Naming.lookup("rmi://localhost:5000/Biggie");
            Rocket biggie = (Rocket) obj;
            System.out.println("Apogee is " + biggie.getApogee());
        } catch (Exception e) {
            System.out.println("Exception while looking up a rocket:");
            e.printStackTrace();
        }
    }
}