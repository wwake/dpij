package com.oozinoz.imaging;

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
import java.io.File;
import javax.swing.*;

/**
 * This class acts as a proxy for another ImageIcon. In "The Design Patterns
 * in Java" we wind up tearing out this class, preferring the techniques
 * used in the ImageIconLoader class.
 * @author Steven J. Metsker
 * @see LoadingImageIcon
 */
public class ImageIconProxy extends ImageIcon implements Runnable {
    static final ImageIcon ABSENT = new ImageIcon(ImageIconProxy.path("resources/images/absent.jpg"));
    static final ImageIcon LOADING = new ImageIcon(ImageIconProxy.path("resources/images/loading.jpg"));
    ImageIcon current = ABSENT;
    protected String filename;
    protected JFrame callbackFrame;

    static String path(String filename) {
        return new File("").getAbsolutePath() + "/" + filename;
    }

    /**
     * Construct an ImageIconProxy that will (on demand) load the image in the
     * provided file.
     * @param filename the name of a file to load
     */
    public ImageIconProxy(String filename) {
        super(ABSENT.getImage());
        this.filename = filename;
    }

    /**
     * Load the desired image and call back the provided frame when done.
     * @param callbackFrame the frame to repaint when the image is loaded
     */
    public void load(JFrame callbackFrame) {
        this.callbackFrame = callbackFrame;
        current = LOADING;
        callbackFrame.repaint();
        new Thread(this).start();
    }

    /**
     * Load the desired image (presumably in a separate thread).
     */
    public void run() {
        current = new ImageIcon(ImageIconProxy.path(filename));
        callbackFrame.pack();
    }
    
    /**
     * @return the height of the Icon
     */
    public int getIconHeight() {
        return current.getIconHeight();
    }

    /**
     * @return the width of the Icon
     */
    public int getIconWidth() {
        return current.getIconWidth();
    }

    /**
     * Paint the Icon
     */
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        current.paintIcon(c, g, x, y);
    }
}