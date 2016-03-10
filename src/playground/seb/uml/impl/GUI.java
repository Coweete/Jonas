package playground.seb.uml.impl;

import playground.seb.uml.SebExempel.MVP_pattern.LoginPresenter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
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
        JOptionPane.showMessageDialog(null, gui);
    }

	@Override
	public LoginPresenter getController() {
		return null;
	}

	@Override
	public void setController(IController controller) {

	}

	@Override
	public void updateMemberServiceFromView() {

	}

	@Override
	public void updateViewFromMemberService() {

	}

	@Override
	public void updateViewFromMediaService() {

	}

	@Override
	public void openLogin() {

	}

	@Override
	public void closeLogin() {

	}

	@Override
	public void userRejected() {

	}

	@Override
	public void showErrorMessage(String error) {

	}

	@Override
	public void openMainView() {

	}

	@Override
	public void closeMainView() {

	}
}
