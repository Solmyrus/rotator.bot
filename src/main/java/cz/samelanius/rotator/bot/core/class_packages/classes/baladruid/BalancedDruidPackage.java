package cz.samelanius.rotator.bot.core.class_packages.classes.baladruid;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.samelanius.rotator.bot.core.class_packages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;

import javax.sound.midi.Soundbank;
import java.awt.event.KeyEvent;

public class BalancedDruidPackage extends AbstractClassPackage {
    private BalancedDruidParser parser = new BalancedDruidParser();
    private BalancedDruidPlayerData player;

    private final static int INSECT_SWARM_KEY = KeyEvent.VK_NUMPAD3;
    private final static int FAERIE_FIRE_KEY = KeyEvent.VK_NUMPAD4;
    private final static int MOON_FIRE_KEY = KeyEvent.VK_NUMPAD1;
    private final static int STAR_FIRE_KEY = KeyEvent.VK_NUMPAD2;

    @Override
    public void load() {
        player = new BalancedDruidPlayerData();
    }

    @Override
    public ResultAction update(RawScreenData data) {
        player = parser.parseData(data, player);
        logComData(data,player);

        if (!player.isActive()) return ResultAction.noAction("Neni aktivni");
        if (player.isCasting()) return ResultAction.noAction("Casti");

        if (player.getSpellInsectSwarm().isCastable()) {
            return ResultAction.keyPress(INSECT_SWARM_KEY);
        } else if (player.getSpellFaerieFire().isCastable()) {
            return ResultAction.keyPress(FAERIE_FIRE_KEY);
        } else {
            /** pokud je thortle rezim - casti moofire v behu bez ohledu na dotky **/
            if(player.isRunning()) {
                System.out.println("D");
                if(player.isRunningModeEnable() && player.getSpellRepeatableMoonFire().isCastable()) {
                    return ResultAction.keyPress(MOON_FIRE_KEY);
                }
            } else {
                if(player.getSpellMoonFire().isCastable())  {
                    return ResultAction.keyPress(MOON_FIRE_KEY);
                }
                else if(player.getSpellStarFire().isCastable())  {
                    return ResultAction.keyPress(STAR_FIRE_KEY);
                }
            }
        }
        return ResultAction.noAction("Konec stromu");

    }


    @Override
    public void unload() {

    }

}