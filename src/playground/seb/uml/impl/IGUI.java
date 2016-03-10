package playground.seb.uml.impl;

import playground.seb.uml.SebExempel.MVP_pattern.LoginPresenter;

/**
 * Created by seb on 2016-03-10.
 */
public interface IGUI {
	LoginPresenter getController();

	void setController(IController controller);

	void updateModelFromView();

	void updateViewFromModel();

	void open();

	void close();

	void userRejected();
}
