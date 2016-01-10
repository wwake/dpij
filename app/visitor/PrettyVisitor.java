package app.visitor;

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

import java.util.List;
import java.util.HashSet;
import java.util.Set;

import com.oozinoz.process.*;

/**
 * This class uses the visitor mechanics of the process hierarchy to add a
 * behavior that pretty-prints a process composite. The prettiness is basically
 * indentation, although alternations are prefixed with a question mark to note
 * that they're alternations.
 * 
 * This visitor takes care not to print any component twice, if the original
 * component is cyclic. On encountering a node a second time, this visitor will
 * print an ellipsis (...).
 */
public class PrettyVisitor implements ProcessVisitor {
    public static final String INDENT_STRING = "    ";

    private StringBuffer buf;
    private int depth;
    private Set visited;

    /**
     * @param pc the process component to portray
     * @return a pretty (indented) description of the supplied process component.
     */
    public StringBuffer getPretty(ProcessComponent pc) {
        buf = new StringBuffer();
        visited = new HashSet();
        depth = 0;
        pc.accept(this);
        return buf;
    }

    protected void printIndentedString(String s) {
        for (int i = 0; i < depth; i++) 
            buf.append(INDENT_STRING);
        buf.append(s);
        buf.append("\n");
    }

    /**
     * Add a step to the output buffer.
     * @param s the step
     */
    public void visit(ProcessStep s) {
        printIndentedString(s.getName());
    }

    /**
     * Add an alternation to the output buffer.
     * @param a the alternation
     */
    public void visit(ProcessAlternation a) {
        visitComposite("?", a);
    }

    /**
     * Add a sequence to the output buffer.
     * @param s the sequence
     */
    public void visit(ProcessSequence s) {
        visitComposite("", s);
    }

    /**
     * Print the prefix and name of this composite, and print its children. If
     * we've printed this element before, just print an ellipsis instead of
     * printing the children again.
     * 
     * @param prefix a possible prefix
     * @param c the composite to display
     */
    protected void visitComposite(String prefix, ProcessComposite c) {
        if (visited.contains(c)) {
            printIndentedString(prefix + c.getName() + "...");
        } else {
            visited.add(c);
            printIndentedString(prefix + c.getName());
            depth++;

            List children = c.getChildren();

            for (int i = 0; i < children.size(); i++) {
                ProcessComponent child = (ProcessComponent) children.get(i);
                child.accept(this);
            }

            depth--;
        }
    }
}