package com.oozinoz.process;

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
 * This class provides an object model of Oozinoz's process for making an aerial
 * shell.
 */
public class ShellProcess {
    protected static ProcessSequence make;

    /**
     * @return an object model of Oozinoz's process for making an aerial shell.
     */
    public static ProcessSequence make() {
        if (make == null) {
            make = new ProcessSequence("Make an aerial shell");
            make.add(buildInnerShell());
            make.add(inspect());
            make.add(reworkOrFinish());
        }
        return make;
    }

    protected static ProcessStep buildInnerShell() {
        return new ProcessStep("Build inner shell");
    }

    protected static ProcessStep inspect() {
        return new ProcessStep("Inspect");
    }

    protected static ProcessAlternation reworkOrFinish() {
        return new ProcessAlternation("Rework inner shell, or complete shell",
                new ProcessComponent[] { rework(), finish() });
    }

    protected static ProcessSequence rework() {
        return new ProcessSequence("Rework", new ProcessComponent[] {
                disassemble(), make() });
    }

    protected static ProcessStep disassemble() {
        return new ProcessStep("Disassemble");
    }

    protected static ProcessStep finish() {
        return new ProcessStep("Finish: Attach lift, insert fusing, wrap");
    }
}