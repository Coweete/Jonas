package testing.seb;


import Jonas.Controller.IController;
import Jonas.Model.*;
import Jonas.View.Gui;
import Jonas.View.IGUI;

import java.io.IOException;

/***
 * Controller that handles the communication between Model/service and the View
 *
 * @author Sebastian Boreback
 */
public class DummyController implements IController {
	private IGUI gui;
	private IMediaService mediaService;
	private IMemberService memberService;


	@Override
	public IMemberService getMemberService() {
		return this.memberService;
	}

	@Override
	public IMediaService getMediaService() {
		return this.mediaService;
	}

	@Override
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public void setMediaService(IMediaService IMediaService) {
		this.mediaService = IMediaService;
	}

	@Override
	public IGUI getView() {
		return gui;
	}

	@Override
	public void setView(IGUI gui) {
		this.gui = gui;
	}

	@Override
	public void run() {
		try {
			this.mediaService.loadMedia();
			this.memberService.loadMember();
		} catch (IOException e) {
			gui.showErrorMessage("Failed load media and members");
		}
		memberService.setCurrentUserID("none");
		this.gui.setController(this);

//		this.gui.openLogin();
		this.login();
	}


	@Override
	public void login() {
		gui.updateMemberServiceFromView();
		// TODO Just for testing
		memberService.setCurrentUserID("681102-9999");

		try {
			if (memberService.userExists()) {
				gui.closeLogin();
				this.gui.updateViewFromMemberService();
				this.gui.updateViewFromMediaService();
				gui.openMainView();
			} else {
				gui.showErrorMessage("Invalid Username");
				gui.openLogin();
			}
		} catch (NullPointerException e) {
			System.exit(0);
		}
	}


	@Override
	public void logout() {
		memberService.setCurrentUserID("none");
		gui.closeMainView();
		System.out.println("logout");
		gui.openLogin();

	}

	@Override
	public void borrow(String mediaID) {
		Media media = mediaService.getMedia(mediaID);
		if (media == null) {
			this.gui.updateViewFromMediaService();
			gui.showErrorMessage("Ange giltigt mediaID");
			return;
		}
		if (media.isBorrowed()) {
			gui.showMessage("Bok är redan lånad");
		} else {
			memberService.getCurrentUser().loanMedia(media);
			media.setBorrowed(true);
		}
		this.gui.updateViewFromMediaService();
	}

	@Override
	public void returnMedia(String mediaID) {
		Media media = mediaService.getMedia(mediaID);
		if (media == null) {
			this.gui.updateViewFromMediaService();
			gui.showErrorMessage("Ange giltigt mediaID");
			return;
		}
		if (media.isBorrowed()) {
			memberService.getCurrentUser().returnMedia(media);
			media.setBorrowed(false);
		} else {
			gui.showMessage("Bok är inte utlånad");
		}
		this.gui.updateViewFromMediaService();
	}

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				IMediaService IMediaService = new DummyMediaService("files/Media.txt");
				IMemberService memberService = new MemberService("files/Lantagare.txt");

				DummyController controller = new DummyController();
				controller.setMediaService(IMediaService);
				controller.setMemberService(memberService);

				IGUI gui = new Gui();
				controller.setView(gui);

				controller.run();

			}
		});

	}
}
