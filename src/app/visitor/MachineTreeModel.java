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

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import com.oozinoz.machine.Machine;
import com.oozinoz.machine.MachineComponent;
import com.oozinoz.machine.MachineComposite;

/**
 * This class adapts a machine composite to behave as a tree model.
 * 
 * (You might think that this class should subclass DefaultTreeModel, but that
 * class requires its nodes to be TreeNode objects.)
 * 
 * @author Steven J. Metsker
 */
public class MachineTreeModel implements TreeModel {
    protected MachineComponent root;

    /**
     * Ignored.
     */
    public void addTreeModelListener(javax.swing.event.TreeModelListener l) {
    }

    /**
     * @param parent
     *            a node in the tree
     * @return the child of the parent at the given index
     */
    public Object getChild(Object parent, int index) {
        if (parent instanceof MachineComposite) {
            MachineComposite c = (MachineComposite) parent;
            return c.getComponents().get(index);
        }
        return null;
    }

    /**
     * 
     * @param parent
     *            a node in the tree
     * @return the number of children of the given node
     */
    public int getChildCount(Object parent) {
        if (parent instanceof MachineComposite) {
            MachineComposite c = (MachineComposite) parent;
            return c.getComponents().size();
        }
        return 0;
    }

    /**
     * @param parent
     *            a node in the tree
     * @param child
     *            a node in the tree
     * @return the index of the child at the parent node
     */
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof MachineComposite) {
            MachineComposite c = (MachineComposite) parent;
            return c.getComponents().indexOf(child);
        }
        return 0;
    }

    /**
     * @return the root of the tree
     */
    public Object getRoot() {
        return root;
    }

    /**
     * @param node
     *            a node in the tree
     * @return true if the given node is a leaf
     */
    public boolean isLeaf(Object node) {
        return node instanceof Machine;
    }

    /**
     * Ignored.
     */
    public void removeTreeModelListener(javax.swing.event.TreeModelListener l) {
    }

    /**
     * Ignored.
     */
    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    /**
     * Construct a tree model of the supplied MachineComponent object.
     */
    public MachineTreeModel(MachineComponent root) {
        this.root = root;
    }
}