package cz.samelanius.rotator.bot.core.classpackages;

import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

public interface ClassPackage {

    void load();
    ResultActions update(RawScreenData data);
    void unload();
}
