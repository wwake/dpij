package app.mediator.moveATub2;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MoveATubMediator implements ListSelectionListener, ActionListener {
    MoveATub2 gui;
    NameBase data;
    
    private Object selectedMachine;
    private Object selectedTub;
    
    public MoveATubMediator(MoveATub2 gui, NameBase data) {
        this.gui = gui;
        this.data = data;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (selectedMachine == null || selectedTub == null) return;
            String tubName = selectedTub.toString();
            String fromMachineName = data.getMachineContaining(tubName);
            String toMachineName = selectedMachine.toString();
            data.put(tubName, toMachineName);
            updateTubList(fromMachineName);
            gui.assignButton().setEnabled(false);
    }
    
    public void valueChanged(ListSelectionEvent e) {
        JList sender = (JList) e.getSource();

        if (! sender.isSelectionEmpty()) {
            Object selection = sender.getSelectedValue();
            
            if (sender.equals(gui.boxList())) 
                this.updateTubList(selection.toString());
            else if (sender.equals(gui.machineList())) 
                selectedMachine = selection;
            else if (sender.equals(gui.tubList()))
                selectedTub = selection;
        }
        
        gui.assignButton().setEnabled( 
            ! gui.tubList().isSelectionEmpty() && ! gui.machineList().isSelectionEmpty());
    }
    
    public void updateTubList(String machineName)
    {
        gui.tubList().setListData(data.tubNames(machineName));
    }
}
