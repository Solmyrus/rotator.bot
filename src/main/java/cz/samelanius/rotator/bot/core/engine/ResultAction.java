package cz.samelanius.rotator.bot.core.engine;

import lombok.Data;

@Data
public class ResultAction {
    public static ResultAction noAction(String detailMessage) {
        ResultAction action = new ResultAction();
        action.setType(ActionType.WAIT_ACTION);
        action.setDetailMessage(detailMessage);
        return action;
    }

    public static ResultAction noAction() {
        return noAction(null);
    }

    public static ResultAction keyPress(int keyCode) {
        ResultAction action = new ResultAction();
        action.setType(ActionType.KEY_PRESS_ACTION);
        action.setKeyCode(keyCode);
        action.setModificatorKeyCode(-1);
        return action;
    }


    public static ResultAction keyPress(int keyCode, int modificatorKeyCode) {
        ResultAction action = new ResultAction();
        action.setType(ActionType.KEY_PRESS_ACTION);
        action.setKeyCode(keyCode);
        action.setModificatorKeyCode(modificatorKeyCode);
        return action;
    }

    private ActionType type;
    private int keyCode;
    private int modificatorKeyCode;
    private String detailMessage;


}
