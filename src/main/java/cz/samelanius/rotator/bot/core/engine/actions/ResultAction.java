package cz.samelanius.rotator.bot.core.engine.actions;

import cz.samelanius.rotator.bot.core.communication.screenparsing.ScreenController;

public interface ResultAction {
    void apply(ScreenController screenController);
}
