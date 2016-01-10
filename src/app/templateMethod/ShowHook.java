package app.templateMethod;

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

import aster2.*;

import com.oozinoz.businessCore.*;

public class ShowHook {
   public static void main(String[] args) {
      AsterStarPress p = new AsterStarPress();
      Hook h = new Hook() {
        public void execute(AsterStarPress p) {
            MaterialManager m = MaterialManager.getManager();
            m.setMoldIncomplete(p.getCurrentMoldID());
        }
      };
   
      p.setMoldIncompleteHook(h);
   }
}