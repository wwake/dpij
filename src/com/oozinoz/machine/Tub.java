package com.oozinoz.machine;

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
*  A tub is a standard, rubber container that contains
*  about four liters of a chemical. This class is a minimal
*  model that helps show how to manage a one-to-many
*  relation in an object model.
*/
public class Tub {
    private String id;

    private TubMediator mediator = null;

    /**
    *  Create a tub with the given id and managed by the given
    *  mediator.
    * @param id the identity of this machine
    */
    public Tub(String id, TubMediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    /**
    *  Use a mediator to control getting and setting the location
    *  of this tub. This prevents a tub from ever being modeled as
    *  being on two machines at once.
    */
    public Machine getLocation() {
        return mediator.getMachine(this);
    }

    public void setLocation(Machine value) {
        mediator.set(this, value);
    }

    /**
    *  @return a textual representation of this tub.
    */
    public String toString() {
        return id;
    }

    /**
    *  @return a unique id for this tub.
    */
    public int hashCode() {
        return id.hashCode();
    }

    /**
    *  @return true if, according to business rules, this
    *  component and the supplied object refer to the same
    *  thing.
    * @param o The candidate to compare to
    */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj.getClass() != Tub.class)
            return false;

        Tub that = (Tub) obj;
        return id.equals(that.id);
    }
}