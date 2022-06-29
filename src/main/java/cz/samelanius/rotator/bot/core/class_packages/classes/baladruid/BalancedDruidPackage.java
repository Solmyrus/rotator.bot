package cz.samelanius.rotator.bot.core.class_packages.classes.baladruid;

import cz.samelanius.rotator.bot.core.class_packages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.class_packages.CastType;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;



public class BalancedDruidPackage extends AbstractClassPackage {

    private BalancedDruidParser parser = new BalancedDruidParser();

    private BalancedDruidPlayerData player;

    private BalancedDruidStrategyStandard standardStrategy = new BalancedDruidStrategyStandard();

    private BalancedDruidStrategyFastAdd fastAddStrategy = new BalancedDruidStrategyFastAdd();

    @Override
    public void load() {}

    @Override
    public ResultAction update(RawScreenData data) {
        player = parser.parseData(data);
        if(player == null) return ResultAction.noAction();

        logComData(data,player);

        if (!player.isActive()) {
            return ResultAction.noAction("Neni aktivni");
        }

        if (!player.getCasting().equals(CastType.NONE)) {
            if(player.getCastingTimeRemaining() > 0.3) {
                return ResultAction.noAction("Casti");
            }
        }

        if(fastAddStrategy.isOnWhitelist(player.getTargetName())) return fastAddStrategy.update(player);

        return standardStrategy.update(player);
    }

    @Override
    public void unload() {

    }

}
