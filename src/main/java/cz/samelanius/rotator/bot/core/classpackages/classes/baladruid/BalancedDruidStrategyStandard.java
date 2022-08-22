package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid;

import cz.samelanius.rotator.bot.core.ThreatTools;
import cz.samelanius.rotator.bot.core.engine.actions.KeyPress;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid.BalancedDruidKeybindigs.*;

public class BalancedDruidStrategyStandard implements BalancedDruidStrategy {

    @Override
    public ResultActions update(BalancedDruidPlayerData player) {
        if (player.isActivateManaPotion()) return ResultActions.action(KeyPress.pressKey(MANA_POTION_KEY));
        if (player.isActivateDarkRune()) return ResultActions.action(KeyPress.pressKey(DARK_RUNE_KEY));
        if (player.isActivateTrinket()) return ResultActions.action(KeyPress.pressKey(TRINKET_KEY));
        if (player.isActivateDrums()) return ResultActions.action(KeyPress.pressKey(DRUMS_KEY));
        if (player.isActivateInnervate()) return ResultActions.action(KeyPress.pressKey(INNERVATE_KEY));
        if (player.isActivateDestructionPotion())
            return ResultActions.action(KeyPress.pressKey(DESTRUCTION_POTION_KEY).withModificator(MODIFICATOR_KEY_CODE));

        if (player.getSpellInsectSwarm().isCastable()) {
            return ResultActions.action(KeyPress.pressKey(INSECT_SWARM_KEY));
        } else if (player.getSpellFaerieFire().isCastable()) {
            return ResultActions.action(KeyPress.pressKey(FAERIE_FIRE_KEY));
        } else {
            /** pokud je thortle rezim - casti moofire v behu bez ohledu na dotky **/
            if (player.isRunning()) {
                if (player.isRunningModeEnable() && player.getSpellRepeatableMoonFire().isCastable()) {
                    if (!player.isThreatLock() || (ThreatTools.isSafe(player, 100, 5000)))
                        return ResultActions.action(KeyPress.pressKey(MOON_FIRE_KEY));
                    else return ResultActions.noAction("Overaggro - specific");
                }

            } else {
                if (player.getSpellMoonFire().isCastable()) {
                    if (!player.isThreatLock() || (ThreatTools.isSafe(player, 100, 5000)))
                        return ResultActions.action(KeyPress.pressKey(MOON_FIRE_KEY));
                    else return ResultActions.noAction("Overaggro - specific");
                } else if (player.getSpellStarFire().isCastable()) {
                    if (!player.isThreatLock() || (ThreatTools.isSafe(player, 100, 15000)))
                        return ResultActions.action(KeyPress.pressKey(STAR_FIRE_KEY));
                    else return ResultActions.noAction("Overaggro - specific");
                }
            }
        }
        return ResultActions.noAction();
    }


}
