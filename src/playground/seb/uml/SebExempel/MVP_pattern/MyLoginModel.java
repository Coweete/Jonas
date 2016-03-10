/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package Playground.MVP_pattern;

/**
 * Created by Sebastian Börebäck on 2016-03-08.
 */
public class MyLoginModel implements LoginModel{
	String user;

	@Override
	public String getUser() {
		return user;
	}

	@Override
	public void setUser(String user) {
		this.user = user;
	}

}
