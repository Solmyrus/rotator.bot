package cz.samelanius.rotator.bot.core.engine.actions;

import cz.samelanius.rotator.bot.core.communication.screenparsing.ScreenController;

import java.awt.event.KeyEvent;

public class KeyPress implements ResultAction {

    private boolean holdShift;

    private boolean holdCtrl;

    private boolean holdAlt;

    private int keyCode;

    private KeyPress(int keyCode) {
        this.keyCode = keyCode;
    }

    public static KeyPress pressKey(int keyCode) {
        return new KeyPress(keyCode);
    }

    public KeyPress withShift() {
        holdShift = true;
        return this;
    }

    public KeyPress withCtrl() {
        holdCtrl = true;
        return this;
    }

    public KeyPress withAlt() {
        holdAlt = true;
        return this;
    }

    public KeyPress withModificator(Integer modificatorKeyCode) {

        if(modificatorKeyCode == null) return this;

        if(modificatorKeyCode == KeyEvent.VK_ALT) withAlt();
        if(modificatorKeyCode == KeyEvent.VK_CONTROL) withCtrl();
        if(modificatorKeyCode == KeyEvent.VK_SHIFT) withShift();
        return this;
    }

    @Override
    public void apply(ScreenController screenController) {
        System.out.println("MACKAM " + keyCode);
        if(holdAlt) screenController.pressKey(KeyEvent.VK_ALT);
        if(holdCtrl) screenController.pressKey(KeyEvent.VK_CONTROL);
        if(holdShift) screenController.pressKey(KeyEvent.VK_SHIFT);

        screenController.pressKey(keyCode);
        screenController.releaseKey(keyCode);

        if(holdShift) screenController.releaseKey(KeyEvent.VK_SHIFT);
        if(holdCtrl) screenController.releaseKey(KeyEvent.VK_CONTROL);
        if(holdAlt) screenController.releaseKey(KeyEvent.VK_ALT);
    }


}
