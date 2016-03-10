package playground.seb.uml.impl;

/**
 * Created by seb on 2016-03-10.
 */

/**
 * Main class for creating the MediaBiblotek App.
 */
public class AppMain {
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				MediaService mediaService = new MediaService();
				MemberService memberService = new MemberService();
				Controller controller = new Controller();
				IGUI gui = new GUI();
				controller.setView(gui);

				controller.setMediaService(mediaService);
				controller.setMemberService(memberService);



//				LoginModel loginModel = new MyLoginModel();
//				LoginPresenter loginPresenter = new MyLoginPresenter();
//				loginPresenter.setModel(loginModel);
//				LoginView loginView = new MyLoginView();
//				loginPresenter.setView(loginView);
//				loginPresenter.setOnLogin(new Runnable() {
//
//					@Override
//					public void run() {
//						JOptionPane.showMessageDialog(null, "Welcome user!");
//					}
//				});
//				loginPresenter.run();
			}
		});

	}
}
