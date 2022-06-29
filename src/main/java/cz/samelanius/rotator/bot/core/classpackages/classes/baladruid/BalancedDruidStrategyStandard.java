package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid;

import cz.samelanius.rotator.bot.core.engine.ResultAction;

import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid.BalancedDruidKeybindigs.*;

public class BalancedDruidStrategyStandard implements BalancedDruidStrategy {

    @Override
    public ResultAction update(BalancedDruidPlayerData player) {
        if(player.isActivateManaPotion()) return ResultAction.keyPress(MANA_POTION_KEY);
        if(player.isActivateDarkRune()) return ResultAction.keyPress(DARK_RUNE_KEY);
        if(player.isActivateTrinket()) return ResultAction.keyPress(TRINKET_KEY);
        if(player.isActivateDrums()) return ResultAction.keyPress(DRUMS_KEY);
        if(player.isActivateInnervate()) return ResultAction.keyPress(INNERVATE_KEY);
        if(player.isActivateDestructionPotion()) return ResultAction.keyPress(DESTRUCTION_POTION_KEY, MODIFICATOR_KEY_CODE);

        if (player.getSpellInsectSwarm().isCastable()) {
            return ResultAction.keyPress(INSECT_SWARM_KEY);
        } else if (player.getSpellFaerieFire().isCastable()) {
            return ResultAction.keyPress(FAERIE_FIRE_KEY);
        } else {
            /** pokud je thortle rezim - casti moofire v behu bez ohledu na dotky **/
            if(player.isRunning()) {
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
        return ResultAction.noAction();
    }


}
