package cz.samelanius.rotator.bot.core.classpackages.classes.protwar;

import cz.samelanius.rotator.bot.core.classpackages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.CastType;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.actions.KeyPress;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

import java.awt.event.KeyEvent;

public class ProtWarPackage extends AbstractClassPackage {
    public static String PACKAGE_ID = "pw_01";

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
    public ResultActions update(RawScreenData data) {
        player = parser.parseData(data, player);
        logComData(data,player);

        if (!player.isActive()) return ResultActions.noAction("Neaktivni");

        if (!player.getCasting().equals(CastType.NONE) && player.getCastingTimeRemaining() > 0.3) {
                return ResultActions.noAction("Casti");
        }

        if (player.isPossibleShieldBlock()) {
            System.out.println("Castim Shield block");
            return  ResultActions.action(KeyPress.pressKey(SHIELD_BLOCK_KEY));
        }

        if (player.isPossibleRevenge()) {
            System.out.println("Castim Revenge");
            return  ResultActions.action(KeyPress.pressKey(REVENGE_KEY));
        }

        if (player.isPossibleShieldSlam()) {
            System.out.println("Castim Shiel Slam");
            return  ResultActions.action(KeyPress.pressKey(SHIELD_SLAM_KEY));
        }

        if (player.isPossibleDevastate()) {
            System.out.println("Castim Devastate");
            return  ResultActions.action(KeyPress.pressKey(DEVASTATE_KEY));
        }

        if (player.isPossibleHeroicStrike() && player.getRage().getValue() > 30) {
            System.out.println("Castim Heroic Strike");
            return ResultActions.action(KeyPress.pressKey(HEROIC_STRIKE_KEY));
        }

        return ResultActions.noAction("Konec stromu");
    }

    @Override
    public void unload() {

    }
}
