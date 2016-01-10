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

import java.io.*;

import com.oozinoz.filter.RandomCaseFilter;
import com.oozinoz.filter.WrapFilter;

/**
 * Show filters that wrap text at 15 characters, center the text, set the text
 * to random casing, and direct the output to System.out
 * 
 * @author Steven J. Metsker
 */
public class ShowFilters2 {
    public static void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        Writer out = new PrintWriter(System.out);
        out = new WrapFilter(new BufferedWriter(out), 15);
 
        ((WrapFilter) out).setCenter(true);
        out = new RandomCaseFilter(out);
        
        while (true) {
            String s = in.readLine();
            if (s == null)
                break;
            out.write(s + "\n");
        }
     
        out.close();
        in.close();
    }
}