package Gui;

import playground.seb.uml.impl.*;

/**
 * Created by jonatan on 2016-03-10.
 */
public class TestGuiCtrl implements IController {
    @Override
    public IMemberService getMemberService() {
        return null;
    }

    @Override
    public MediaService getMediaService() {
        return null;
    }

    @Override
    public void setMemberService(IMemberService memberService) {

    }

    @Override
    public void setMediaService(MediaService mediaService) {

    }

    @Override
    public GUI getView() {
        return null;
    }

    @Override
    public void setView(IGUI gui) {

    }


    @Override
    public void run() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void borrow(String mediaID) {

    }

    @Override
    public void returnBook(String mediaID) {

    }
}
