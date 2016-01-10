package app.mediator.moveATub;

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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.oozinoz.ui.SwingFacade;
import com.oozinoz.ui.UI;

/**
 * This class is partially refactored, with a method for each control. The
 * next step will be to create a mediator class, factoring the action logic
 * out of this class.
 */
public class MoveATub extends JPanel implements ListSelectionListener, ActionListener {
    private static Hashtable tubMachine;

    private List boxes;
    private JList boxList;

    private JList tubList;
    private Object selectedTub;

    private JList machineList;
    private Object selectedMachine;

    private JButton assignButton;

    private UI ui = UI.NORMAL;

    public static void main(String[] args) {
        JFrame frame = SwingFacade.launch(new MoveATub(), "Move a Tub");
        frame.setSize(600, 250);
        frame.validate();
    }

    public MoveATub() {
        super(new GridLayout(1, 4));
        setFont(ui.getFont());

        this.add(labeledPanel("From Machine...", boxList()));
        this.add(labeledPanel("Move Tub...", tubList()));
        this.add(labeledPanel("To Machine...", machineList()));
        this.add(buttonPanel(assignButton()));
    }

    private Component buttonPanel(JButton button) {
        JPanel result = new JPanel(new GridLayout(3, 1));
        result.add(new JLabel(" "));

        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPanel.add(button);
        result.add(innerPanel);

        result.add(new JLabel(" "));
        return result;
    }

    private Component labeledPanel(String label, JList list) {
        JPanel result = new JPanel(new BorderLayout());
        result.add(new JLabel(label), BorderLayout.NORTH);
        result.add(new JScrollPane(list), BorderLayout.CENTER);

        int borderWidth = 15;
        result.setBorder(BorderFactory.createEmptyBorder(borderWidth, borderWidth, borderWidth, borderWidth));

        return result;
    }

    // This is a temporary approach that has hard-coded literals
    private List boxes() {
        if (boxes == null) {
            boxes = new ArrayList();
            boxes.add("Mixer-2201");
            boxes.add("Mixer-2202");
            boxes.add("Fuser-2101");
            boxes.add("StarPress-2401");
            boxes.add("StarPress-2402");
            boxes.add("Assembler-2301");
        }
        return boxes;
    }

    private JList boxList() {
        if (boxList == null) {
            boxList = ui.createList(boxes().toArray());
            boxList.addListSelectionListener(this);
        }
        return boxList;
    }

    private JList machineList() {
        if (machineList == null) {
            machineList = ui.createList(boxes().toArray());
            machineList.addListSelectionListener(this);
        }
        return machineList;
    }

    private JList tubList() {
        if (tubList == null) {
            tubList = ui.createList(new String[] {});
            tubList.addListSelectionListener(this);
        }
        return tubList;
    }

    private JButton assignButton() {
        if (assignButton == null) {
            assignButton = new JButton("Do it!");
            assignButton.setEnabled(false);
            assignButton.addActionListener(this);
        }
        return assignButton;
    }

    private static Hashtable tubMachine() {
        if (tubMachine == null) {
            tubMachine = new Hashtable();
            tubMachine.put("T502", "Mixer-2201");
            tubMachine.put("T503", "Mixer-2201");
            tubMachine.put("T504", "Mixer-2201");
            tubMachine.put("T101", "StarPress-2402");
            tubMachine.put("T102", "StarPress-2402");
        }
        return tubMachine;
    }

    private static List tubNames(String machineName) {
        ArrayList result = new ArrayList();

        Enumeration iter = tubMachine().keys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement().toString();
            String value = tubMachine().get(key).toString();
            if (value.equals(machineName)) result.add(key);
        }

        return result;
    }

    private void updateTubList(String machineName) {
        List tubs = tubNames(machineName);
        tubList().setListData(tubs.toArray());
    }

    public void valueChanged(ListSelectionEvent e) {
        JList sender = (JList) e.getSource();

        if (!sender.isSelectionEmpty()) {
            if (sender.equals(boxList())) 
                updateTubList(sender.getSelectedValue().toString());
            
            if (sender.equals(machineList())) 
                selectedMachine = sender.getSelectedValue();
            
            if (sender.equals(tubList())) 
                selectedTub = sender.getSelectedValue();
        }

        assignButton().setEnabled(
                !tubList().isSelectionEmpty() && !machineList().isSelectionEmpty());
    }

    public void actionPerformed(ActionEvent e) {
        if (selectedMachine == null || selectedTub == null) return;
        String tubName = selectedTub.toString();
        String fromMachineName = (String) tubMachine().get(tubName);
        String toMachineName = selectedMachine.toString();
        tubMachine().put(tubName, toMachineName);
        updateTubList(fromMachineName);
        assignButton().setEnabled(false);
    }
}