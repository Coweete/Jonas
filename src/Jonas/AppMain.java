package Jonas;

import Jonas.Controller.Controller;
import Jonas.Model.IMediaService;
import Jonas.Model.IMemberService;
import Jonas.Model.MediaService;
import Jonas.Model.MemberService;
import Jonas.View.Gui;
import Jonas.View.IGUI;

/**
 * Main class for creating the MediaBiblotek App.
 * @author Sebastian Boreback
 */
public class AppMain {
	/**
	 * The main
	 * @param args main args
	 */
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
