package Gui;

import playground.seb.uml.impl.Controller;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author Jonatan Fridsten, Johnatan Sona, Gustaf Bohlin
 * This is the class containing all Graphical components
 */
public class Gui extends JFrame {
    private Controller ctrl;

    public Gui(){

    }


    private JPanel basicJPanel(String labelInfo, JTextField textField,JButton button, String borderString) {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel();
        JLabel label = new JLabel(labelInfo);
        EmptyBorder padding = new EmptyBorder(5, 5, 5, 5);//detta e cancer
        label.setBorder(padding);
        textField.setBorder(padding);
        panel1.add(button);
        button.setBorder(padding);
        TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), borderString);
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(panel1, BorderLayout.EAST);
        panel.setBorder(border);
        return panel;
    }

    public void setCtrl(Controller ctrl){
        this.ctrl = ctrl;
    }

    public static void main(String [] args){
        Gui gui = new Gui();
        JFrame frame = new JFrame();
        frame.add(gui.basicJPanel("cancer", new JTextField(20), new JButton("cancer"), "cancer"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
