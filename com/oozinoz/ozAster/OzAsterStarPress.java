package com.oozinoz.ozAster;

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

import aster.AsterStarPress;

import com.oozinoz.businessCore.*;

public class OzAsterStarPress extends AsterStarPress {
    /**
    *  Override the superclass to have our robot collect the
    *  discharged paste before the star presses flushes
    *  itself with water.
    */
    public void dischargePaste() {
        super.dischargePaste();
        getFactory().collectPaste();
    }

    /**
    *  @return the material manager singleton.
    */
    public MaterialManager getManager() {
        return MaterialManager.getManager();
    }

    /**
    *  Let the Oozinoz material manager know that this
    *  mold is only partly processed.
    *  @param id which mold
    */
    public void markMoldIncomplete(int id) {
        getManager().setMoldIncomplete(id);
    }

    /**
    *  @return the factory singleton; not actually implemented
    */
    public Factory getFactory() {
        return null;
    }
}