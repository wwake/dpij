package app.proxy;

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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.oozinoz.ui.*;
import com.oozinoz.imaging.*;

/**
 * Show the use of ImageIconLoader, a class that shows the intent of the Proxy
 * pattern without actually applying the Proxy pattern. Rather than forwarding
 * calls around, this class just switches the image that is displayed. For this
 * class to execute, an "images" directory must be in the classpath, and this
 * directory must contain absent.jpg, loading.jpg, and fest.jpg.
 * @author Steven J. Metsker
 */
public class ShowLoader implements ActionListener {
    private JFrame frame;
    private JButton loadButton;

    /**
     * Start loading the image and disable the Load button.
     */
    public void actionPerformed(ActionEvent e) {
        loader.load(frame);
        loadButton().setEnabled(false);
    }

    protected JButton loadButton() {
        if (loadButton == null) {
            loadButton = new JButton("Load");
            loadButton.addActionListener(this);
            loadButton.setFont(SwingFacade.getStandardFont());
        }
        return loadButton;
    }

    /**
     * Show the use of ImageIconLoader.
     */
    public static void main(String[] args) {
        ShowLoader sl = new ShowLoader();
        sl.frame = SwingFacade.launch(sl.mainPanel(), " Proxy");
    }

    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add("Center", new JLabel(loader));
        p.add("South", loadButton());
        return p;
    }

    private LoadingImageIcon loader = new LoadingImageIcon("images/fest.jpg");
}