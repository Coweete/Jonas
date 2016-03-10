package Gui;

import playground.seb.uml.impl.GUI;
import playground.seb.uml.impl.IController;
import playground.seb.uml.impl.MediaService;
import playground.seb.uml.impl.MemberService;

/**
 * Created by jonatan on 2016-03-10.
 */
public class TestGuiCtrl implements IController {
    @Override
    public MemberService getMemberService() {
        return null;
    }

    @Override
    public MediaService getMediaService() {
        return null;
    }

    @Override
    public void setMemberService(MemberService memberService) {

    }

    @Override
    public void setMediaService(MediaService mediaService) {

    }

    @Override
    public GUI getView() {
        return null;
    }

    @Override
    public void setView(GUI gui) {

    }

    @Override
    public void run() {

    }

    @Override
    public void login() {

    }

    @Override
    public void findMedia() {

    }
}
