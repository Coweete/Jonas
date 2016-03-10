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
        EmptyBorder padding = new EmptyBorder(5, 5, 5, 5);
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
    public JPanel panelList(JTextArea txtList){
        JPanel panel = new JPanel();
        JLabel lblText = new JLabel("Lånde objekt: ");
        JScrollPane spText = new JScrollPane(txtList);
        spText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.setLayout(new BorderLayout());
        TitledBorder border = new TitledBorder(BorderFactory.createLineBorder(Color.black), "Lista Lånad Media");
        panel.setBorder(border);
        panel.add(lblText,BorderLayout.WEST);
        panel.add(spText,BorderLayout.CENTER);
        return panel;
    }

    public String login (){
        String txt = JOptionPane.showInputDialog(null,"Skriv in ditt personnummer");
        return txt;
    }

    public void setCtrl(Controller ctrl){
        this.ctrl = ctrl;
    }

    public static void main(String [] args){
        Gui gui = new Gui();
        JFrame frame = new JFrame();
        String txt = "iahfuahfuhwfhwhfiqwhriqhwifhqwirhiqwhfiwqriqwhrqiwhrwhq";
        frame.add(gui.panelList(new JTextArea("txt")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
