package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */
public interface IController {

	IMemberService getMemberService();
	IMediaService getMediaService();

	void setMemberService(IMemberService memberService);

	void setMediaService(IMediaService IMediaService);

	/**
	 * Get current view
	 * @return the current view
	 */
	IGUI getView();

	/**
	 * Set view
	 * @param gui
	 */
	void setView(IGUI gui);

	/**
	 * Run the app
	 */
	void run();

	/**
	 * Login user
	 */
	void login();

	/**
	 * Logout current User
	 */
	void logout();

	/**
	 * Borrow book
	 */
	void borrow(String mediaID);

	/**
	 * Return book
	 */
	void returnBook(String mediaID);
}
