package app.abstractFactory;

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

import javax.swing.JFrame;

import com.oozinoz.ui.SwingFacade;
import com.oozinoz.ui.UI;
import com.oozinoz.visualization.Visualization2;

/** Show the use of an alternative GUI kit (an alternative
 *  abstract factory).
*/
public class ShowVisualization2 {
    public static void main(String[] args) {
        Visualization2 panel = new Visualization2(UI.NORMAL);
        JFrame frame = SwingFacade.launch(panel, "Operational Model");
        
        frame.setJMenuBar(panel.menus());
        frame.setVisible(true);
    }
}
