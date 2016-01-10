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

import java.io.Writer;

/**
*  This "filter" directs its characters to the console.
*/
public class ConsoleWriter extends Writer {
    public void close() {}
    public void flush() {}
    
    public void write(char[] buffer, int offset, int length) {
        for (int i = 0; i < length; i++) 
            System.out.print(buffer[offset + i]);
    }
}