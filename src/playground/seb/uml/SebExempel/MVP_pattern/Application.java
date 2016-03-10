/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package Playground.MVP_pattern;

import javax.swing.JOptionPane;

/**
 * Created by Sebastian Börebäck on 2016-03-08.
 */
public class Application {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				LoginModel loginModel = new MyLoginModel();
				LoginPresenter loginPresenter = new MyLoginPresenter();
				loginPresenter.setModel(loginModel);
				LoginView loginView = new MyLoginView();
				loginPresenter.setView(loginView);
				loginPresenter.setOnLogin(new Runnable() {

					@Override
					public void run() {
						JOptionPane.showMessageDialog(null, "Welcome user!");
					}
				});
				loginPresenter.run();
			}
		});
	}
}