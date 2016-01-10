package app.composite;

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

import com.oozinoz.machine.*;

/**
*  This class sets up a challenge in the Composite chapter.
*/
public class ShowPlant 
{
  public static void main(String[] args) 
  {
      MachineComponent c = OozinozFactory.plant();
      System.out.println("Number of machines: " + c.getMachineCount());
  }
}