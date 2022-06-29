package cz.samelanius.rotator.bot.core.classpackages;

import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;

public interface ClassPackage {

    void load();
    ResultAction update(RawScreenData data);
    void unload();
}
