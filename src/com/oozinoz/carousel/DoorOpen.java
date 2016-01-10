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

/**
 * Model the behavior of a carousel door when it's open.
 */
public class DoorOpen extends DoorState {
    public DoorOpen(Door2 door) {
        super(door);
    }

    /**
     * This is a nonintuitive behavior of the "one touch" system. Once open the
     * door will begin closing automatically after a few seconds (the timeout).
     * You can prevent this with an extra touch that indicates the door should
     * remain open.
     */
    public void touch() {
        door.setState(door.STAYOPEN);
    }

    /**
     * Start closing if the door is open and the door machinery sends a timeout
     * signal.
     */
    public void timeout() {
        door.setState(door.CLOSING);
    }
}