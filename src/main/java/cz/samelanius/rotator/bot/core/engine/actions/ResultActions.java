package cz.samelanius.rotator.bot.core.engine.actions;

import cz.samelanius.rotator.bot.core.communication.screenparsing.ScreenController;
import lombok.Data;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResultActions {
    private List<ResultAction> actionSequence = new ArrayList<>();

    private String message;

    public static ResultActions noAction() {
        return new ResultActions();
    }

    public static ResultActions noAction(String message) {
        ResultActions actions = new ResultActions();
        actions.setMessage(message);
        return actions;
    }

    public static ResultActions action(ResultAction action) {

        ResultActions actions = new ResultActions();
        actions.getActionSequence().add(action);
        return actions;
    }


    public void apply(ScreenController screenController) {
        System.out.println("Provadim: " + message);
        for (ResultAction resultAction : actionSequence) resultAction.apply(screenController);
    }
}
