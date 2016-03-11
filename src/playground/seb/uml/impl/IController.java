package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */
public interface IController {

	/**
	 * Get the memberService
	 * @return the memberService
	 */
	IMemberService getMemberService();

	/**
	 * Get the mediaService
	 * @return the mediaService
	 */
	IMediaService getMediaService();

	/**
	 * Set the memberService
	 * @param memberService the memberService we are using
	 */
	void setMemberService(IMemberService memberService);

	/**
	 * Set the mediaService
	 * @param IMediaService the mediaService
	 */
	void setMediaService(IMediaService IMediaService);

	/**
	 * Get current view
	 *
	 * @return the current view
	 */
	IGUI getView();

	/**
	 * Set view
	 *
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
