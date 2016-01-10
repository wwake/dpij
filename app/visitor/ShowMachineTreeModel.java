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

import javax.swing.JScrollPane;
import javax.swing.JTree;

import com.oozinoz.machine.OozinozFactory;
import com.oozinoz.ui.SwingFacade;

public class ShowMachineTreeModel {

    public ShowMachineTreeModel() {
        MachineTreeModel model = new MachineTreeModel(OozinozFactory.dublin());
        JTree tree = new JTree(model);
        tree.setFont(SwingFacade.getStandardFont());
        SwingFacade.launch(new JScrollPane(tree), " A New Oozinoz Factory");
    }

    public static void main(String[] args) {
        new ShowMachineTreeModel();
    }
}