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
 * This class provides object models of a few of Oozinoz's factories, in terms
 * of the factories' machines.
 */

public class OozinozFactory {
    /**
     * @return a model of the machines in our Dublin facility.
     */
    public static MachineComposite dublin() {
        MachineRoot root = new MachineRoot(0, new Engineer(4096));
        root.setName(" Factory Dublin");
        TubMediator m = new TubMediator();
        root.add(line1(m, root));
        root.add(line2(m, root));
        root.add(line3(m, root));
        return root;
    }

    /**
     * @return a sample manufacturing line
     */
    public static MachineComposite line1(TubMediator m, MachineComposite parent) {
        MachineComposite c = new MachineComposite(1000, parent);
        c.setName("Line 1");
        c.add(new Machine[] { new Mixer(1201, m, c), new StarPress(1401, m, c),
                new ShellAssembler(1301, m, c), new Fuser(1101, m, c) });
        return c;
    }

    /**
     * @return a second sample manufacturing line
     */
    public static MachineComposite line2(TubMediator m, MachineComposite parent) {
        MachineComposite c = new MachineComposite(2000, parent);
        c.setName("Line 2");
        c.add(new Machine[] { new Mixer(2201, m, c), new Mixer(2202, m, c),
                new StarPress(2401, m, c), new StarPress(2402, m, c),
                new ShellAssembler(2301, m, c), new Fuser(2101, m, c) });
        return c;
    }

    /**
     * @return a third sample manufacturing line
     */
    public static MachineComposite line3(TubMediator m, MachineComposite parent) {
        MachineComposite c = new MachineComposite(3000, parent);
        c.setName("Line 3");
        c.add(new Machine[] { new Mixer(3201, m, c), new Mixer(3202, m, c),
                new Mixer(3203, m, c), new Mixer(3204, m, c),
                new StarPress(3401, m, c), new StarPress(3402, m, c),
                new StarPress(3403, m, c), new StarPress(3404, m, c),
                new ShellAssembler(3301, m, c), new ShellAssembler(3302, m, c),
                new Fuser(3101, m, c), new Fuser(3102, m, c) });
        return c;
    }

    /**
     * @return a plant (a factory) that is not a tree.
     */
    public static MachineComposite plant() {
        MachineComposite plant = new MachineComposite(100);
        MachineComposite bay = new MachineComposite(101);
        Machine mixer = new Mixer(102);
        Machine press = new StarPress(103);
        Machine assembler = new ShellAssembler(104);
        bay.add(mixer);
        bay.add(press);
        bay.add(assembler);
        plant.add(mixer);
        plant.add(bay);
        return plant;
    }
}