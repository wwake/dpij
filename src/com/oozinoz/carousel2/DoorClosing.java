package com.oozinoz.carousel2;

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
 * Model the behavior of a carousel door when it's closing. This refactoring
 * uses constant state values.
 * 
 * @author Steven J. Metsker
 */
public class DoorClosing extends DoorState {
    /**
     * Stop closing and start opening the door.
     */
    public void touch(Door door) {
        door.setState(OPENING);
    }

    /**
     * Stop closing and close the door.
     */
    public void complete(Door door) {
        door.setState(DoorConstants.CLOSED);
    }
}