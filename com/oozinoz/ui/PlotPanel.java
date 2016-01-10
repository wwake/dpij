package com.oozinoz.ui;

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

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.oozinoz.function.Function;

/**
 * This class displays pair of functions in a panel. The functions
 * are x and y functions, parameterized by time. As the panel plots,
 * time goes 0 to 1.
 */
public class PlotPanel extends JPanel {
    private int points;

    private int[] xPoints;
    private int[] yPoints;

    private Function xFunction;
    private Function yFunction;

    /**
     * Create a plot calculated from the provided x and y functions.
     * These functions must be functions of time; time goes 0 to 1
     * as the panel plots.
     */
    public PlotPanel(int nPoint, Function xFunc, Function yFunc) {
        points = nPoint;
        xPoints = new int[points];
        yPoints = new int[points];
        xFunction = xFunc;
        yFunction = yFunc;
        setBackground(Color.WHITE);
    }

    protected void paintComponent(Graphics graphics) {
        double w = getWidth() - 1;
        double h = getHeight() - 1;
      
        for (int i = 0; i < points; i++) {
            double t = ((double) i) / (points - 1);
            xPoints[i] = (int) (xFunction.f(t) * w);
            yPoints[i] = (int) (h * (1 - yFunction.f(t)));
        }

        graphics.drawPolyline(xPoints, yPoints, points);
    }
}