package playground.seb.uml.impl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jonatan Fridsten on 2016-03-10.
 */
public class GUI extends JPanel implements IGUI{
	private Controller ctrl;
	private JPanel panel = new JPanel();


	public GUI(){
        this.setPreferredSize(new Dimension(700,600));
	}

	public void setCtrl(Controller ctrl){
		this.ctrl = ctrl;
	}

    public static void main(String [] args){
        GUI gui = new GUI();
        JOptionPane.showMessageDialog(null,gui);
    }
}
