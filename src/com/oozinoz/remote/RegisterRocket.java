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
 * Make a particular rocket object available to clients through an RMI server as
 * an object named Biggie. This class expects the RMI registry to be running and
 * listening to port 5000.
 * @author Steven J. Metsker
 */
public class RegisterRocket {
    /**
     * Make a particular rocket object available to clients through an RMI
     * server.
     */
    public static void main(String[] args) {
        try {
            Rocket biggie = new RocketImpl(29.95, 820);
            Naming.rebind("rmi://localhost:5000/Biggie", biggie);
            System.out.println("Registered biggie");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}