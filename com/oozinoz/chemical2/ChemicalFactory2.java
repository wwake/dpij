package com.oozinoz.chemical2;

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
 * This class creates and returns Chemical objects. This is a refactoring that
 * ensures that the factory class is the only class that can instantiate the
 * ChemicalImpl class.
 */
public class ChemicalFactory2 {
    private static Map chemicals = new HashMap();

    class ChemicalImpl implements Chemical {
        private String name;
        private String symbol;
        private double atomicWeight;

        ChemicalImpl(String name, String symbol, double atomicWeight) {
            this.name = name;
            this.symbol = symbol;
            this.atomicWeight = atomicWeight;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }

        public double getAtomicWeight() {
            return atomicWeight;
        }
        
        public String toString() {
            return name + "(" + symbol + ")[" + atomicWeight + "]";
        }
    }

    static {
        ChemicalFactory2 factory = new ChemicalFactory2();
        chemicals.put("carbon", factory.new ChemicalImpl("Carbon", "C", 12));
        chemicals.put("sulfur", factory.new ChemicalImpl("Sulfur", "S", 32));
        chemicals.put("saltpeter", factory.new ChemicalImpl("Saltpeter", "KN03", 101));
        //...
    }

    /**
     * @param name the name of the interesting chemical
     * @return the Chemical object for the given name.
     */
    public static Chemical getChemical(String name) {
        return (Chemical) chemicals.get(name.toLowerCase());
    }
}