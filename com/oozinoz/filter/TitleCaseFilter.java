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
 * Make characters title case, meaning that characters after whitespace are in
 * upper case.
 * @author Steven J. Metsker
 */
public class TitleCaseFilter extends OozinozFilter {
    boolean inWhite = true;

    /**
     * Construct a filter that pass title case characters to the supplied
     * stream.
     * @param out a writer to which to pass down writes
     */
    public TitleCaseFilter(Writer out) {
        super(out);
    }

    /**
     * Pass a title-cased version of the supplied character to the underlying
     * stream.
     * @param c the character to write
     * @throws IOException if an I/O error occurs
     */
    public void write(int c) throws IOException {
        out.write(inWhite ? Character.toUpperCase((char) c) : Character.toLowerCase((char) c));
        inWhite = Character.isWhitespace((char) c) || c == '"';
    }
}