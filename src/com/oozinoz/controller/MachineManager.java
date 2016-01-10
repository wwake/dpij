package com.oozinoz.controller;

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
*  An example for the Bridge chapter. This is an abstract
*  class and an example of an abstraction--a class with 
*  concrete methods that rely on other, abstract methods.
*/
public abstract class MachineManager
{
    public abstract void startMachine();
    public abstract void stopMachine();
    public abstract void startProcess();
    public abstract void stopProcess();
    public abstract void conveyIn();
    public abstract void conveyOut();
  
    public void shutdown() 
    {
        stopProcess();
        conveyOut();
        stopMachine();
    }
}