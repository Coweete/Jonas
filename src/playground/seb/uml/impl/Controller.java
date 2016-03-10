package playground.seb.uml.impl;

/**
 * Created by Sebastian Börebäck on 2016-03-09.
 */

/***
 * Controller that handles the communication between Model/service and the View
 */
public class Controller implements IController {
	private IGUI gui;
	private MediaService mediaService;
	private IMemberService memberService;
	private Runnable onLogin;

	/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */


	public Controller() {


	}

	@Override
	public IMemberService getMemberService() {
		return this.memberService;
	}

	@Override
	public MediaService getMediaService() {
		return this.mediaService;
	}

	@Override
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
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
		memberService.setCurrentUser("none");
		this.gui.setController(this);

		this.gui.updateViewFromMemberService();
		this.gui.openLogin();
	}

	@Override
	public void login() {
		gui.updateMemberServiceFromView();
		if(memberService.userExists())
		{
			gui.closeLogin();
			gui.openMainView();
		}
	}


	@Override
	public void logout() {
		memberService.setCurrentUser("none");
		gui.closeMainView();
		gui.openLogin();
	}

	@Override
	public void borrow(String mediaID) {
		Media media = mediaService.getMedia(mediaID);
		memberService.getCurrentUser().loanMedia(media);
		this.gui.updateViewFromMemberService();
	}

	@Override
	public void returnBook(String mediaID) {
		Media media = mediaService.getMedia(mediaID);
		memberService.getCurrentUser().returnMedia(media);
		this.gui.updateViewFromMemberService();
	}
}
