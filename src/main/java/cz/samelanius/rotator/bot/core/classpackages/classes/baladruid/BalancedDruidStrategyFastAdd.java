package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid;

import cz.samelanius.rotator.bot.core.engine.actions.KeyPress;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid.BalancedDruidKeybindigs.*;

public class BalancedDruidStrategyFastAdd implements BalancedDruidStrategy {
    private List<String> mobWhitelist = new ArrayList<>();

    public BalancedDruidStrategyFastAdd() {
        createWhitelist();
    }

    private void createWhitelist() {
        mobWhitelist = new ArrayList<>();
        mobWhitelist.add("Void Sentinel");
        mobWhitelist.add("Shield Orb");
        mobWhitelist.add("Astral Flare");

    }

    @Override
    public ResultActions update(BalancedDruidPlayerData player) {
        if (player.getTarget().getTargetHealth() > 8_000) {
            if (player.getSpellStarFire().isCastable()) return ResultActions.action(KeyPress.pressKey(STAR_FIRE_KEY));
        } else {
            if (player.getSpellRepeatableMoonFire().isCastable()) return ResultActions.action(KeyPress.pressKey(MOON_FIRE_KEY));
            if (player.getSpellStarFire().isCastable()) return ResultActions.action(KeyPress.pressKey(STAR_FIRE_KEY));
        }

        return ResultActions.noAction();
    }

    public boolean isOnWhitelist(String mobName) {
        return mobWhitelist.contains(mobName);
    }


}
