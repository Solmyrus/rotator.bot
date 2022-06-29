package cz.samelanius.rotator.bot.core.classpackages.classes.protwar;

import cz.samelanius.rotator.bot.core.classpackages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.CastType;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;

import java.awt.event.KeyEvent;

public class ProtWarPackage extends AbstractClassPackage {
    private ProtWarParser parser = new ProtWarParser();
    private ProtWarPlayerData player;

    private static final int REVENGE_KEY = KeyEvent.VK_NUMPAD1;
    private static final int SHIELD_BLOCK_KEY = KeyEvent.VK_NUMPAD3;
    private static final int SHIELD_SLAM_KEY = KeyEvent.VK_NUMPAD2;
    private static final int DEVASTATE_KEY = KeyEvent.VK_NUMPAD4;
    private static final int HEROIC_STRIKE_KEY = KeyEvent.VK_NUMPAD5;

    @Override
    public void load() {
        player = new ProtWarPlayerData();
    }

    @Override
    public ResultAction update(RawScreenData data) {
        player = parser.parseData(data, player);
        logComData(data,player);

        if (!player.isActive()) return ResultAction.noAction("Neaktivni");

        if (!player.getCasting().equals(CastType.NONE) && player.getCastingTimeRemaining() > 0.3) {
                return ResultAction.noAction("Casti");
        }

        if (player.isPossibleShieldBlock()) {
            System.out.println("Castim Shield block");
            return ResultAction.keyPress(SHIELD_BLOCK_KEY);
        }

        if (player.isPossibleRevenge()) {
            System.out.println("Castim Revenge");
            return ResultAction.keyPress(REVENGE_KEY);
        }

        if (player.isPossibleShieldSlam()) {
            System.out.println("Castim Shiel Slam");
            return ResultAction.keyPress(SHIELD_SLAM_KEY);
        }

        if (player.isPossibleDevastate()) {
            System.out.println("Castim Devastate");
            return ResultAction.keyPress(DEVASTATE_KEY);
        }

        if (player.isPossibleHeroicStrike() && player.getRage().getValue() > 30) {
            System.out.println("Castim Heroic Strike");
            return ResultAction.keyPress(HEROIC_STRIKE_KEY);
        }

        return ResultAction.noAction("Konec stromu");
    }

    @Override
    public void unload() {

    }
}
