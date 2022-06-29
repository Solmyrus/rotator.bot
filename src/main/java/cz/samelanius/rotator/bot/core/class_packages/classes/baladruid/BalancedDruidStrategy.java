package cz.samelanius.rotator.bot.core.class_packages.classes.baladruid;

import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;

public interface BalancedDruidStrategy {
    ResultAction update(BalancedDruidPlayerData player);
}
