package app.mediator.moveATub2;

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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class NameBase {
    private List boxes;
    private Hashtable tubMachine;
 
    public Object[] boxes()
    {
        if (boxes == null) 
        {
            boxes = new ArrayList();
            boxes.add("Mixer-2201");
            boxes.add("Mixer-2202");  
            boxes.add("Fuser-2101");
            boxes.add("StarPress-2401");    
            boxes.add("StarPress-2402");
            boxes.add("Assembler-2301");
        }
        return boxes.toArray();
    }
    
    private Hashtable tubMachine()
    {
        if (tubMachine == null) 
        {
            tubMachine = new Hashtable();
            tubMachine.put("T502", "Mixer-2201");
            tubMachine.put("T503", "Mixer-2201");
            tubMachine.put("T504", "Mixer-2201");
            tubMachine.put("T101", "StarPress-2402");
            tubMachine.put("T102", "StarPress-2402");
        }
        return tubMachine;
    } 
    
    public Object[] tubNames(String machineName)
    {
        ArrayList result = new ArrayList();
        
        Enumeration iter = this.tubMachine().keys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement().toString();
            String value = getMachineContaining(key);
            if (value.equals(machineName))
                result.add(key);
        }
        
        return result.toArray();
    }

    public String getMachineContaining(String tubName) {
        return (String) tubMachine().get(tubName);
    }

    public void put(String tubName, String toMachineName) {
        tubMachine().put(tubName, toMachineName);
    }
}
