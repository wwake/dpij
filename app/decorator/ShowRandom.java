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

import java.io.BufferedWriter;
import java.io.IOException;

import com.oozinoz.filter.ConsoleWriter;
import com.oozinoz.filter.RandomCaseFilter;

/**
 * Show the effects of randomizing text.
 */
public class ShowRandom {
    public static void main(String[] args) throws IOException {
        BufferedWriter w = 
            new BufferedWriter(new RandomCaseFilter(new ConsoleWriter()));
        w.write("buy two packs now and get a "
                + "zippie pocket rocket -- free!");
        w.newLine();
        w.close();
    }
}