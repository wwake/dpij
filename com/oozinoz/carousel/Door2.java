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

import java.util.Observable;

/**
 * This refactoring of the Door class moves state-specific logic to a separate
 * class hierarchy.
 */
public class Door2 extends Observable {
    public final DoorState CLOSED = new DoorClosed(this);
    public final DoorState CLOSING = new DoorClosing(this);
    public final DoorState OPEN = new DoorOpen(this);
    public final DoorState OPENING = new DoorOpening(this);
    public final DoorState STAYOPEN = new DoorStayOpen(this);

    private DoorState state = CLOSED;

    /**
     * The carousel user has touched the carousel button. This "one touch"
     * button elicits different behaviors, depending on the state of the door.
     */
    public void touch() {
        state.touch();
    }

    /**
     * This is a notification from the mechanical carousel that the door
     * finished opening or shutting.
     */
    public void complete() {
        state.complete();
    }

    /**
     * This is a notification from the mechanical carousel that the door got
     * tired of being open.
     */
    public void timeout() {
        state.timeout();
    }

    /**
     * @return a textual description of the door's state
     */
    public String status() {
        return state.status();
    }

    protected void setState(DoorState state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }
}