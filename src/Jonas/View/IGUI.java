package Jonas.View;

import Jonas.Controller.IController;

/**
 * @author Sebastian Borreback, ... 2016-03-10.
 */
public interface IGUI {
	/**
	 * Set current controller
	 * @param controller the controller for the view
	 */
	void setController(IController controller);

	/**
	 * Update the MemberService with the current login member
	 * from View
	 */
	void updateMemberServiceFromView();

	/**
	 * Update the view from the MemberService.
	 * Who logged in.
	 */
	void updateViewFromMemberService();

	/**
	 * Update the MediaService from the View
	 */
	void updateViewFromMediaService();

	/**
	 * Open the View
	 */
	void openLogin();

	/**
	 * Close the view
	 */
	void closeLogin();

	/**
	 * open MainView
	 */
	void openMainView();

	/**
	 * Close MainView
	 */
	void closeMainView();

	/**
	 * Show error message to user
	 * @param error the error message.
	 */
	void showErrorMessage(String error);

	/**
	 * Show message to user
	 * @param message the message
	 */
	void showMessage(String message);

}
