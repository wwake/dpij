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
 * Make all characters lower case.
 * 
 * @author Steven J. Metsker
 */
public class LowerCaseFilter extends OozinozFilter {
    /**
     * Construct a filter that pass lower case characters to the supplied
     * stream.
     * 
     * @param out a writer to which to pass down writes
     */
    public LowerCaseFilter(Writer out) {
        super(out);
    }

    /**
     * Pass a lower case version of the supplied character to the underlying
     * stream.
     * 
     * @param c
     *            the character to write
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    public void write(int c) throws IOException {
        out.write(Character.toLowerCase((char) c));
    }
}