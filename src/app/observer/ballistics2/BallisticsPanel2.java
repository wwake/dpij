package app.observer.ballistics2;

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

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.oozinoz.ballistics.BallisticsFunction;

/**
 * Plot a ballistics function. This class is refactored from BallisticsPanel_1
 * to register its interest in a slider's value.
 * 
 * @author Steven J. Metsker
 */
public class BallisticsPanel2 extends JPanel implements ChangeListener {
    protected BallisticsFunction func;

    protected int nPoint = 101;

    protected double tPeak = 0.0;

    protected int[] x = new int[nPoint];

    protected int[] y = new int[nPoint];

    protected JSlider slider;

    /**
     * Create a panel that can display the provided function, evaluated against
     * the value of the provided slider.
     * 
     * @param func
     *            the ballistics function to plot. Ballistics functions vary
     *            with time and with the time of peak burn area.
     * 
     * @param JSlider
     *            a slider to observe
     */
    public BallisticsPanel2(BallisticsFunction func, JSlider slider) {
        this.func = func;
        this.slider = slider;
        slider.addChangeListener(this);
    }

    /**
     * Update the label when the slider moves.
     * 
     * @param e ChangeEvent object (ignored)
     */
    public void stateChanged(ChangeEvent e) {
        double val = slider.getValue();
        double max = slider.getMaximum();
        double min = slider.getMinimum();
        tPeak = (val - min) / (max - min);
        repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background
        for (int i = 0; i < nPoint; i++) {
            double t = ((double) i) / (nPoint - 1);
            x[i] = (int) (t * getWidth());
            y[i] = (int) (getHeight() * (1 - func.function(t, tPeak)));
        }
        g.drawPolyline(x, y, nPoint);
    }
}