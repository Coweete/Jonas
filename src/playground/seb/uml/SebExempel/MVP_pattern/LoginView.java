/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package Playground.MVP_pattern;

/**
 * Created by Sebastian Börebäck on 2016-03-08.
 */
public interface LoginView {

	LoginPresenter getPresenter();

	void setPresenter(LoginPresenter loginPresenter);

	void updateModelFromView();

	void updateViewFromModel();

	void open();

	void close();

	void userRejected();
}
