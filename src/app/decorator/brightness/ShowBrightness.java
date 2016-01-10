package app.decorator.brightness;

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

import com.oozinoz.function.*;
import com.oozinoz.ui.SwingFacade;

/**
 * Show the brightness of a (fireworks) star.
 * 
 * @author Steven J. Metsker
 */
public class ShowBrightness {
   public static void main(String args[]) {
        FunPanel panel = new FunPanel();
        panel.setPreferredSize(new java.awt.Dimension(200, 200));
        
        Function brightness = new Arithmetic(
                '*', 
                new Exp(
                    new Arithmetic(
                        '*',
                        new Constant(-4), 
                        new T())), 
                new Sin(
                    new Arithmetic(
                        '*',
                        new Constant(Math.PI), 
                        new T())));
      
        panel.setXY(new T(), brightness);
        
        SwingFacade.launch(panel, "Brightness");
    }
}