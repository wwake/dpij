package com.oozinoz.carousel;

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

/** Model the behavior of a carousel door when it's opening. */
public class DoorOpening extends DoorState {
    public DoorOpening(Door2 door) {
        super(door);
    }

    /**
     * Stop opening and start closing the door.
     */
    public void touch() {
        door.setState(door.CLOSING);
    }

    /**
     * We're done opening so the door is now open.
     */
    public void complete() {
        door.setState(door.OPEN);
    }
}