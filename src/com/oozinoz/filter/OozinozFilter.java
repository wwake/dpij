package com.oozinoz.filter;

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

import java.io.*;

/**
 * This class channels all versions of the write() method to go through the
 * write() method that takes a single character.
 * 
 * @author Steven J. Metsker
 */
public abstract class OozinozFilter extends FilterWriter {
    protected OozinozFilter(Writer out) {
        super(out);
    }

    /**
     * Write a portion of an array of characters.
     * 
     * @param cbuf
     *            Buffer of characters to be written
     * @param offset
     *            Offset from which to start reading characters
     * @param length
     *            Number of characters to be written
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    public void write(char cbuf[], int offset, int length) throws IOException {
        for (int i = 0; i < length; i++) 
            write(cbuf[offset + i]);
    }

    /**
     * Write a single character.
     * 
     * @throws IOException if an I/O error occurs
     */
    public abstract void write(int c) throws IOException;

    /**
     * Write a portion of a string.
     * 
     * @param str
     *            String to be written
     * @param offset
     *            Offset from which to start reading characters
     * @param length
     *            Number of characters to be written
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    public void write(String s, int offset, int length) throws IOException {
        write(s.toCharArray(), offset, length);
    }
}