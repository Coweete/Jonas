package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */

import javax.swing.*;
import Gui.Gui;
import sun.net.ResourceManager;

/**
 * Main class for creating the MediaBiblotek App.
 */
public class AppMain {
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				MediaService mediaService = new MediaService("Media.txt");
				IMemberService memberService = new MemberService("Lantagare.txt");

				Controller controller = new Controller();
				controller.setMediaService(mediaService);
				controller.setMemberService(memberService);

				IGUI gui = new Gui();
				controller.setView(gui);

				controller.run();

			}
		});

	}
}
