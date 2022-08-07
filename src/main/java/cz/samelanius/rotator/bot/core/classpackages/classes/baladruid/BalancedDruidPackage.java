package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid;

import cz.samelanius.rotator.bot.core.ThreatTools;
import cz.samelanius.rotator.bot.core.classpackages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.CastType;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;



public class BalancedDruidPackage extends AbstractClassPackage {

    public static String PACKAGE_ID = "bd_01";

    private BalancedDruidParser parser = new BalancedDruidParser();

    private BalancedDruidStrategyStandard standardStrategy = new BalancedDruidStrategyStandard();

    private BalancedDruidStrategyFastAdd fastAddStrategy = new BalancedDruidStrategyFastAdd();

    @Override
    public void load() {
        // Nothing to load.
    }

    @Override
    public ResultAction update(RawScreenData data) {
        BalancedDruidPlayerData player = parser.parseData(data);
        if(player == null) return ResultAction.noAction();

        logComData(data,player);

        if (!player.isActive()) {
            return ResultAction.noAction("Neni aktivni");
        }

        if(player.isThreatLock() && !ThreatTools.isSafe(player, 100)) return ResultAction.noAction("Overaggro");

        if (!player.getCasting().equals(CastType.NONE) && player.getCastingTimeRemaining() > 0.3) {
                return ResultAction.noAction("Casti");
        }

        if(fastAddStrategy.isOnWhitelist(player.getTarget().getTargetName())) return fastAddStrategy.update(player);

        return standardStrategy.update(player);
    }

    @Override
    public void unload() {
        // Nothing to unload.
    }


}
