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
 * Model the behavior of a carousel door when it's closed. This refactoring uses
 * constant state values.
 */
public class DoorClosed extends DoorState {
    /**
     * Open the door.
     */
    public void touch(Door door) {
        door.setState(OPENING);
    }
}