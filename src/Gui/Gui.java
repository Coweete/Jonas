package Gui;

import playground.seb.uml.impl.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jonatan Fridsten, Johnatan Sona, Gustaf Bohlin
 * This is the class containing all Graphical components
 */
public class Gui extends JFrame implements ActionListener {
    private Controller ctrl;

    public Gui(){

    }


    private JPanel basicJPanel(String labelInfo, JTextField textField,JButton button, String borderString) {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelButton = new JPanel();
        JPanel panelLabel = new JPanel();
        JLabel label = new JLabel(labelInfo);
        panelButton.add(button);
        panelLabel.add(label);

        TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), borderString);
        panel.add(panelLabel, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(panelButton, BorderLayout.EAST);
        panel.setBorder(border);
        return panel;
    }

    public JPanel userPanel(){
        JPanel userPanel = new JPanel(new BorderLayout());
        JPanel titlePanel = new JPanel();
        JPanel infoPanel = new JPanel(new BorderLayout());
        JTextField tfID = new JTextField(("ctrl.getMemberID"));
        tfID.setEditable(false);
        infoPanel.setBorder(new TitledBorder(""));
        infoPanel.add(new JLabel("PrsNr: "), BorderLayout.WEST);
        infoPanel.add(tfID, BorderLayout.CENTER);
        infoPanel.add(new JButton("Gå bak"), BorderLayout.EAST);
        titlePanel.add(new JLabel("----ANVÄNDARINFORMATION----"));
        userPanel.add(titlePanel, BorderLayout.NORTH);
        userPanel.add(infoPanel, BorderLayout.EAST);


        return userPanel;
    }

    public void setCtrl(Controller ctrl){
        this.ctrl = ctrl;
    }

    public static void main(String [] args){
        Gui gui = new Gui();
        JFrame frame = new JFrame();
        frame.add(gui.userPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {    //bara byta ut e mot knappens riktiga namn
        if(e.getSource() == e) {        //byta login
            ctrl.login();
        }
        else if(e.getSource() == e) {   //låna
            ctrl.borrow(textFieldBorrow.getText());
        }
        else if(e.getSource() == e) {   //lämna tillbaka
            ctrl.returnBook(textFieldBorrow.getText();
        }
    }
}
