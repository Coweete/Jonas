package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */
public interface IController {

	MemberService getMemberService();
	MediaService getMediaService();

	void setMemberService(IMemberService memberService);

	void setMediaService(MediaService mediaService);

	IGUI getView();

	void setView(IGUI gui);

	void setOnLogin(Runnable onLogin);

	void run();

	void login();

	void findMedia();
}
