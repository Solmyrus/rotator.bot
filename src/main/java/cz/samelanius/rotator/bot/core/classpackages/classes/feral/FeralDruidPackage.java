package cz.samelanius.rotator.bot.core.classpackages.classes.feral;

import cz.samelanius.rotator.bot.core.classpackages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.CastType;
import cz.samelanius.rotator.bot.core.classpackages.classes.feral.strategies.BearTankStrategy;
import cz.samelanius.rotator.bot.core.classpackages.classes.feral.strategies.CatFrontStrategy;
import cz.samelanius.rotator.bot.core.classpackages.classes.feral.strategies.CatRearStrategy;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;

public class FeralDruidPackage extends AbstractClassPackage {

    public static String PACKAGE_ID = "fd_01";

    private FeralDruidParser parser = new FeralDruidParser();

    private FeralDruidStrategy catFront = new CatFrontStrategy();

    private FeralDruidStrategy catRear = new CatRearStrategy();

    private FeralDruidStrategy bearTank = new BearTankStrategy();


    @Override
    public void load() {

    }

    @Override
    public ResultAction update(RawScreenData data) {
        FeralDruidPlayerData player = parser.parseData(data);
        if(player == null) return ResultAction.noAction();

        logComData(data,player);

        if (!player.isActive()) {
            return ResultAction.noAction("Neni aktivni");
        }

        if (!player.getCasting().equals(CastType.NONE) && player.getCastingTimeRemaining() > 0.2) {
            return ResultAction.noAction("Casti");
        }

        FeralDruidStrategy actualStrategy = getActualStrategy(player);

        if(actualStrategy == null) ResultAction.noAction();

        return actualStrategy.update(player);
    }

    private FeralDruidStrategy getActualStrategy(FeralDruidPlayerData player) {
        switch (player.getStrategy()) {
            case CAT_FRONTAL: return catFront;
            case CAT_REAR: return catRear;
            case BEAR_TANK: return bearTank;
        }
        return null;
    }

    @Override
    public void unload() {

    }
}
