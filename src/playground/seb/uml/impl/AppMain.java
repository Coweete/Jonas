package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */

import javax.swing.*;

/**
 * Main class for creating the MediaBiblotek App.
 */
public class AppMain {
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				MediaService mediaService = new MediaService();
				IMemberService memberService = new MemberService();

				Controller controller = new Controller();
				controller.setMediaService(mediaService);
				controller.setMemberService(memberService);

				IGUI gui = new GUI();
				controller.setView(gui);

				controller.setOnLogin(new Runnable() {
					@Override
					public void run() {
						JOptionPane.showMessageDialog(null, "Welcome user!");
					}
				});

				controller.run();

			}
		});

	}
}
