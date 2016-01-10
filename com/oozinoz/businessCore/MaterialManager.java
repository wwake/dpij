package com.oozinoz.businessCore;

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
 * This class is a mock up of a class that would run on an an Aster star press
 * and that would somehow connect Oozinoz systems that store information about
 * material.
 */
public class MaterialManager {
    // Force use of the singleton
    private MaterialManager() {
    }

    /**
     * This method is not implemented, but only shows the role of a method that
     * would return a singleton MaterialManager.
     * 
     * @return the material manager singleton
     */
    public static MaterialManager getManager() {
        return null;
    }

    /**
     * This method is not implemented; if it were, it would tell the Oozinoz systems
     * that the provided star press mold was not completely processed.
     */
    public void setMoldIncomplete(int id) {
    }
}