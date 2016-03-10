package Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jonatan Fridsten on 2016-03-10.
 */
public class LoginScreen extends JPanel{
    private JPanel panelCenter = new JPanel();
    private JPanel panelButton = new JPanel();
    private JButton btnLogin = new JButton("Login");
    private JButton btnQuit = new JButton("Quit");
    private JLabel lblText = new JLabel();
    private JTextPane textPane = new JTextPane();
    private Font font = new Font("Italic",Font.ITALIC,20);
    private int mbrNr;

    public LoginScreen(){
        this.setPreferredSize(new Dimension(250,250));
        this.setLayout(new BorderLayout());

        panelButton.setLayout(new GridLayout(0,2));
        panelButton.add(btnLogin);
        panelButton.add(btnQuit);

        lblText.setFont(font);
        lblText.setText("Ange ditt personnummer");

        panelCenter.setLayout(new GridLayout(3,0));
        panelCenter.add(lblText);
        panelCenter.add(textPane);
        panelCenter.add(panelButton);

        add(panelCenter,BorderLayout.CENTER);

    }
    public static void main(String [] args){
        LoginScreen lg = new LoginScreen();
        JOptionPane.showMessageDialog(null,lg);
    }
}
