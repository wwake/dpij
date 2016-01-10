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

/**
*  Show that the idea of composing streams from streams
*  occurs in the Java class libraries.
*/
public class ShowDecorator
{
  public static void main(String[] args) throws IOException
  {
      FileWriter file = new FileWriter("sample.txt");
      BufferedWriter writer = new BufferedWriter(file);
      writer.write("a small amount of sample text");
      writer.newLine();
      writer.close();
  }
}