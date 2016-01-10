package app.facade;

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

import java.awt.Dimension;

import javax.swing.JFrame;
import com.oozinoz.function.Function;
import com.oozinoz.function.T;
import com.oozinoz.ui.PlotPanel;
import com.oozinoz.ui.UI;

public class ShowFlight2 {
    /** Show the flight path of a nonexploding aerial shell.
     */
    public static void main(String[] args) {
        PlotPanel p = new PlotPanel(101, new T(), new ShowFlight2().new YFunction());
        p.setPreferredSize(new Dimension(300, 200));
        
        JFrame frame = new JFrame("Flight Path for Shell Duds");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.getContentPane().add(UI.NORMAL.createTitledPanel("Flight Path", p));
        
        frame.pack();
        frame.setVisible(true);
    }

    private class YFunction extends Function {
        public YFunction() {
            super(new Function[] {});
        }

        public double f(double t) {
            // y is 0 at t = 0, 1; y is 1 at t = .5
            return 4 * t * (1 - t);
        }
    }
}