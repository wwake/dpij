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
 * Define the states for a carousel door.
 */
public interface DoorConstants {
    DoorState CLOSED = new DoorClosed();
    DoorState OPENING = new DoorOpening();
    DoorState OPEN = new DoorOpen();
    DoorState CLOSING = new DoorClosing();
    DoorState STAYOPEN = new DoorStayOpen();
}