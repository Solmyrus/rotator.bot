package cz.samelanius.rotator.bot.core.class_packages.classes.baladruid;

import cz.samelanius.rotator.bot.core.engine.ResultAction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static cz.samelanius.rotator.bot.core.class_packages.classes.baladruid.BalancedDruidKeybindigs.*;

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
    public ResultAction update(BalancedDruidPlayerData player) {
        if (player.getTargetHealth() > 8_000) {
            if (player.getSpellStarFire().isCastable()) return ResultAction.keyPress(STAR_FIRE_KEY);
        } else {
            if (player.getSpellRepeatableMoonFire().isCastable()) return ResultAction.keyPress(MOON_FIRE_KEY);
            if (player.getSpellStarFire().isCastable()) return ResultAction.keyPress(STAR_FIRE_KEY);
        }

        return ResultAction.noAction();
    }

    public boolean isOnWhitelist(String mobName) {
        return mobWhitelist.contains(mobName);
    }


}
