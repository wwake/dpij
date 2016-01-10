package app.observer.ballistics;

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
import javax.swing.*;

import com.oozinoz.ballistics.Ballistics;
import com.oozinoz.ui.SwingFacade;
import com.oozinoz.utility.Format;

import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Show the standard burn rate and thrust equations. This class is covered in
 * the Observer chapter where the class is refactored into ShowBallistics_2. The
 * refactoring will let components observe the slider themselves.
 * 
 * @author Steven J. Metsker
 */
public class ShowBallistics implements ChangeListener {
    /**
     * Show the standard burn rate and thrust equations.
     */
    public static void main(String[] args) {
        SwingFacade.launch(new ShowBallistics().mainPanel(),
                "Effects of tPeak");
    }

    protected BallisticsPanel burnPanel;

    protected JSlider slider;
    protected double sliderMax;
    protected double sliderMin;

    protected BallisticsPanel thrustPanel;

    protected JLabel valueLabel;

    /*
     * A panel to contain the two plots.
     */
    protected JPanel curvePanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        p.add(SwingFacade.createTitledPanel("Burn Rate", burnPanel()));
        p.add(SwingFacade.createTitledPanel("Thrust", thrustPanel()));
        return p;
    }

    /*
     * The main panel -- the one that actually gets displayed.
     */
    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(curvePanel(), "Center");
        p.add(sliderBox(), "South");
        return p;
    }

    public JSlider slider() {
        if (slider == null) {
            slider = new JSlider();
            sliderMax = slider.getMaximum();
            sliderMin = slider.getMinimum();
            slider.addChangeListener(this);
            slider.setValue(slider.getMinimum());
        }
        return slider;
    }

    /*
     * The box that holds the slider plus a textual label and a changing label
     * that shows the value of the slider.
     */
    protected Box sliderBox() {
        Box b = Box.createHorizontalBox();
        JLabel label = new JLabel("tPeak");
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(java.awt.Color.black);
        b.add(label);
        b.add(valueLabel());
        b.add(slider());
        return b;
    }

    /**
     * The slider moved!
     */
    public void stateChanged(ChangeEvent e) {
        double val = slider.getValue();
        double tp = (val - sliderMin) / (sliderMax - sliderMin);
        burnPanel().setTPeak(tp);
        thrustPanel().setTPeak(tp);
        valueLabel().setText(Format.formatToNPlaces(tp, 2));
    }

    protected JLabel valueLabel() {
        if (valueLabel == null) {
            valueLabel = new JLabel();
            valueLabel.setFont(SwingFacade.getStandardFont());
            valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(java.awt.Color.black);
        }
        return valueLabel;
    }

    protected BallisticsPanel burnPanel() {
        if (burnPanel == null) {
            burnPanel = new BallisticsPanel(Ballistics.rate());
            burnPanel.setPreferredSize(new Dimension(300, 200));
        }
        return burnPanel;
    }

    protected BallisticsPanel thrustPanel() {
        if (thrustPanel == null) {
            thrustPanel = new BallisticsPanel(Ballistics.thrust());
            thrustPanel.setPreferredSize(new Dimension(300, 200));
        }
        return thrustPanel;
    }
}