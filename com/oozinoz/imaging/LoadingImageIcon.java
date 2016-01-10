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

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * This class acts as an ImageIcon that can have three images: an 'absent'
 * image, a 'loading' image, and the target image.
 * @author Steven J. Metsker
 */
public class LoadingImageIcon extends ImageIcon implements Runnable {
    static final ImageIcon ABSENT = new ImageIcon(ClassLoader.getSystemResource("images/absent.jpg"));
    static final ImageIcon LOADING = new ImageIcon(ClassLoader.getSystemResource("images/loading.jpg"));
    protected String filename;
    protected JFrame callbackFrame;

    /**
     * Construct an ImageIconLoader that will (on demand) load the image in the
     * provided file.
     * @param filename the name of a file to load
     */
    public LoadingImageIcon(String filename) {
        super(ABSENT.getImage());
        this.filename = filename;
    }

    /**
     * Load the desired image and call back the provided frame when done.
     * @param JFrame the frame to repaint when the image is loaded
     */
    public void load(JFrame callbackFrame) {
        this.callbackFrame = callbackFrame;
        setImage(LOADING.getImage());
        callbackFrame.repaint();
        new Thread(this).start();
    }

    /**
     * Load the desired image (presumably in a separate thread).
     */
    public void run() {
        setImage(new ImageIcon(ClassLoader.getSystemResource(filename)).getImage());
        callbackFrame.pack();
    }
}