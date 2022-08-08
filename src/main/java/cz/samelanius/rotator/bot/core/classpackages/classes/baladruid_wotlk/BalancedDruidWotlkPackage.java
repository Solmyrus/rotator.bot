package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;

import cz.samelanius.rotator.bot.core.ThreatTools;
import cz.samelanius.rotator.bot.core.classpackages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.CastType;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;



public class BalancedDruidWotlkPackage extends AbstractClassPackage {

    public static String PACKAGE_ID = "bd_wotlk_01";

    private BalancedDruidWotlkParser parser = new BalancedDruidWotlkParser();

    private BalancedDruidWotlkStrategyStandard standardStrategy = new BalancedDruidWotlkStrategyStandard();


    @Override
    public void load() {
        // Nothing to load.
    }

    @Override
    public ResultAction update(RawScreenData data) {
        BalancedDruidWotlkPlayerData player = parser.parseData(data);
        if(player == null) return ResultAction.noAction();

        logComData(data,player);

        if (!player.isActive()) {
            return ResultAction.noAction("Neni aktivni");
        }

        if(player.isThreatLock() && !ThreatTools.isSafe(player, 100)) return ResultAction.noAction("Overaggro");

        if (!player.getCasting().equals(CastType.NONE) && player.getCastingTimeRemaining() > 0.3) {
                return ResultAction.noAction("Casti");
        }

        return standardStrategy.update(player);
    }

    @Override
    public void unload() {
        // Nothing to unload.
    }


}
