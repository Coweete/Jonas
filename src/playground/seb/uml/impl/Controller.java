package playground.seb.uml.impl;

/**
 * Created by Sebastian Börebäck on 2016-03-09.
 */

/***
 * Controller that handles the communication between Model/service and the View
 */
public class Controller implements IController{
	private GUI gui;
	private MediaService mediaService;
	private MemberService memberService;

	public Controller() {


	}

	@Override
	public MemberService getMemberService() {
		return null;
	}

	@Override
	public MediaService getMediaService() {
		return null;
	}

	@Override
	public void setMemberService(MemberService memberService) {

	}

	@Override
	public void setMediaService(MediaService mediaService) {

	}

	@Override
	public GUI getView() {
		return null;
	}

	@Override
	public void setView(IGUI gui) {

	}

	@Override
	public void run() {

	}

	@Override
	public void login() {

	}

	@Override
	public void findMedia() {

	}
}
