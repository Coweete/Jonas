package playground.seb.uml.impl;

import playground.seb.uml.SebExempel.MVP_pattern.LoginPresenter;

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

	@Override
	public LoginPresenter getController() {
		return null;
	}

	@Override
	public void setController(IController controller) {

	}

	@Override
	public void updateModelFromView() {

	}

	@Override
	public void updateViewFromModel() {

	}

	@Override
	public void open() {

	}

	@Override
	public void close() {

	}

	@Override
	public void userRejected() {

	}
}
