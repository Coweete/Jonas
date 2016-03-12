/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package playground.seb.uml.SebExempel.MVP_pattern;/*

/**
 * Created by Sebastian Börebäck on 2016-03-08.
 */
public interface LoginPresenter {

	LoginModel getModel();

	void setModel(LoginModel loginModel);

	LoginView getView();

	void setView(LoginView loginView);

	void setOnLogin(Runnable onLogin);

	void run();

	void login();

}
