package playground.seb.uml.impl;

/**
 * Created by Sebastian Börebäck on 2016-03-09.
 */

import java.io.IOException;

/***
 * Controller that handles the communication between Model/service and the View
 */
public class Controller implements IController {
	private IGUI gui;
	private IMediaService IMediaService;
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
	public IMediaService getMediaService() {
		return this.IMediaService;
	}

	@Override
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public void setMediaService(IMediaService IMediaService) {
		this.IMediaService = IMediaService;
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
			this.IMediaService.loadMedia();
			this.memberService.loadMember();
		} catch (IOException e) {
			gui.showErrorMessage("Failed load media and members");
		}
		memberService.setCurrentUserID("none");
		this.gui.setController(this);

		this.gui.openLogin();
	}

	@Override
	public void login() {
		gui.updateMemberServiceFromView();

		try {
			if(memberService.userExists())
			{
				gui.closeLogin();
				this.gui.updateViewFromMemberService();
				gui.openMainView();
			}
			else {
				gui.showErrorMessage("Invalid Username");
				gui.openLogin();
			}
		} catch (NullPointerException e) {
			gui.showErrorMessage("FUUUUUUUUUUUUUUUUUCK");
			gui.openLogin();
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
		Media media = IMediaService.getMedia(mediaID);
		memberService.getCurrentUser().loanMedia(media);
		System.out.println("borrow");
		this.gui.updateViewFromMediaService();
	}

	@Override
	public void returnBook(String mediaID) {
		Media media = IMediaService.getMedia(mediaID);
		memberService.getCurrentUser().returnMedia(media);
		System.out.println("return");
		this.gui.updateViewFromMediaService();
	}
}
