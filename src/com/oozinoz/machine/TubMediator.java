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

import java.util.*;
/**
 * This class manages the relation of tubs to machines.
 * 
 * @author Steven J. Metsker
 *  
 */
public class TubMediator {
    protected Map tubToMachine = new HashMap();

    public Machine getMachine(Tub t) {
        return (Machine) tubToMachine.get(t);
    }

    public Set getTubs(Machine m) {
        Set set = new HashSet();
        Iterator i = tubToMachine.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry e = (Map.Entry) i.next();
            if (e.getValue().equals(m))
                set.add(e.getKey());
        }
        return set;
    }

    public void set(Tub t, Machine m) {
        tubToMachine.put(t, m);
    }
}