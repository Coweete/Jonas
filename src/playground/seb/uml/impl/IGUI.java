package playground.seb.uml.impl;

import playground.seb.uml.SebExempel.MVP_pattern.LoginPresenter;

/**
 * Created by seb on 2016-03-10.
 */
public interface IGUI {
	LoginPresenter getController();

	void setController(IController controller);

	void updateMemberServiceFromView();

	void updateViewFromMemberService();

	void open();

	void close();

	void userRejected();
}
