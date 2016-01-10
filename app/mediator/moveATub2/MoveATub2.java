package app.mediator.moveATub2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.oozinoz.ui.SwingFacade;
import com.oozinoz.ui.UI;

/**
 * This class is refactored, show a mediator class, factoring the action logic
 * out of this class.
 */
public class MoveATub2 extends JPanel {
    private NameBase data = new NameBase();

    private JList boxList;

    private JList tubList;

    private JList machineList;

    private JButton assignButton;

    private UI ui = UI.NORMAL;
    MoveATubMediator mediator;

    public static void main(String[] args) {
        JFrame frame = SwingFacade.launch(new MoveATub2(), "Move a Tub");
        frame.setSize(600, 250);
        frame.validate();
    }

    public MoveATub2() {
        super(new GridLayout(1, 4));
        mediator = new MoveATubMediator(this, data);

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
        result.setBorder(BorderFactory.createEmptyBorder(borderWidth, borderWidth, borderWidth,
                borderWidth));

        return result;
    }

    public JList boxList() {
        if (boxList == null) {
            boxList = ui.createList(data.boxes());
            boxList.addListSelectionListener(mediator);
        }
        return boxList;
    }

    public JList machineList() {
        if (machineList == null) {
            machineList = ui.createList(data.boxes());
            machineList.addListSelectionListener(mediator);
        }
        return machineList;
    }

    public JList tubList() {
        if (tubList == null) {
            tubList = ui.createList(new String[] {});
            tubList.addListSelectionListener(mediator);
        }
        return tubList;
    }

    public JButton assignButton() {
        if (assignButton == null) {
            assignButton = new JButton("Do it!");
            assignButton.setEnabled(false);
            assignButton.addActionListener(mediator);
        }
        return assignButton;
    }
}