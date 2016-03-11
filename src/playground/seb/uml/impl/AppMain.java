package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */

/**
 * Main class for creating the MediaBiblotek App.
 */
public class AppMain {
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				IMediaService IMediaService = new MediaService("files/Media.txt");
				IMemberService memberService = new MemberService("files/Lantagare.txt");

				Controller controller = new Controller();
				controller.setMediaService(IMediaService);
				controller.setMemberService(memberService);

				IGUI gui = new Gui();
				controller.setView(gui);

				controller.run();

			}
		});

	}
}
