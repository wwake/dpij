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
 * This class just shows a slightly different approach to the same service that
 * ShowFilters2 provides.
 * 
 * @author Steven J. Metsker
 */
public class ShowFilters3 {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        WrapFilter out = new WrapFilter(new BufferedWriter(
                new RandomCaseFilter(new PrintWriter(System.out))), 15);
        out.setCenter(true);
      
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