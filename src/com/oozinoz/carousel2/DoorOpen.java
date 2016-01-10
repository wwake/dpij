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
 * Model the behavior of a carousel door when it's open. This refactoring uses
 * constant state values.
 * 
 * @author Steven J. Metsker
 */
public class DoorOpen extends DoorState {
    /**
     * Stay open until another click comes along.
     */
    public void touch(Door door) {
        door.setState(STAYOPEN);
    }

    /**
     * Start closing a door if it times out.
     */
    public void timeout(Door door) {
        door.setState(DoorConstants.CLOSING);
    }
}