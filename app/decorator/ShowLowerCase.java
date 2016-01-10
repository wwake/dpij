package app.decorator;

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

import com.oozinoz.filter.ConsoleWriter;
import com.oozinoz.filter.LowerCaseFilter;

/**
 * Show how to use a lower case filter.
 */
public class ShowLowerCase {
    public static void main(String[] args) throws IOException {
        Writer out = new ConsoleWriter();
        out = new LowerCaseFilter(out);
        out.write("This Text, notably ALL in LoWeR casE!");
        out.close(); 
    }
}