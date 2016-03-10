package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */

import Gui.Gui;

/**
 * Main class for creating the MediaBiblotek App.
 */
public class AppMain {
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				MediaService mediaService = new MediaService("files/Media.txt");
				IMemberService memberService = new MemberService("files/Lantagare.txt");

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
