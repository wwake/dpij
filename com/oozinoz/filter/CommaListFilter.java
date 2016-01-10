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

import java.io.IOException;
import java.io.Writer;

/**
 * This filter adds comma separators between writes.
 */
public class CommaListFilter extends OozinozFilter {
    protected boolean needComma = false;

    /**
     * Construct a filter that pass random case characters to the supplied
     * stream.
     * 
     * @param writer a stream to pass bytes to
     */
    public CommaListFilter(Writer writer) {
        super(writer);
    }

    /**
     * Plug a comma and a blank in front of this character if need be.
     * @param c the character to write
     */
    public void write(int c) throws IOException {
        if (needComma) {
            out.write(',');
            out.write(' ');
        }
        out.write(c);
        needComma = true;
    }

    /**
     * Plug a comma and a blank in front of this string if need be.
     * @param s the string to write
     */
    public void write(String s) throws IOException {
        if (needComma)
            out.write(", ");

        out.write(s);
        needComma = true;
    }
}