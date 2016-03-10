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
//
//	package playground.seb.uml.SebExempel.MVP_pattern;/*
//
///**
// * Created by Sebastian Börebäck on 2016-03-08.
// */
//	public class MyLoginPresenter implements LoginPresenter{
//		LoginModel loginModel;
//		LoginView loginView;
//		private Runnable onLogin;
//
//		@Override
//		public LoginModel getModel() {
//			return loginModel;
//		}
//
//		@Override
//		public void setModel(LoginModel loginModel) {
//			this.loginModel = loginModel;
//		}
//
//		@Override
//		public LoginView getView() {
//			return loginView;
//		}
//
//		@Override
//		public void setView(LoginView loginView) {
//			this.loginView = loginView;
//		}
//
//		@Override
//		public void setOnLogin(Runnable onLogin) {
//			this.onLogin = onLogin;
//		}
//
//		@Override
//		public void run() {
//			loginModel.setUser("previousUser");
//			loginView.setPresenter(this);
//			loginView.updateViewFromModel();
//			loginView.open();
//		}
//
//		@Override
//		public void login() {
//			loginView.updateModelFromView();
//			if (loginModel.getUser().equalsIgnoreCase("root")) {
//				loginView.close();
//				loginView.setPresenter(null);// for memory sanity.
//				onLogin.run();
//			} else {
//				loginView.userRejected();
//			}
//		}
//	}


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
	public void setOnLogin(Runnable onLogin) {
		this.onLogin = onLogin;
	}

	@Override
	public void run() {

		//			loginModel.setUser("previousUser");
//			loginView.setPresenter(this);
//			loginView.updateViewFromModel();
//			loginView.open();
	}

	@Override
	public void login() {

	}

	@Override
	public void findMedia() {

	}
}
