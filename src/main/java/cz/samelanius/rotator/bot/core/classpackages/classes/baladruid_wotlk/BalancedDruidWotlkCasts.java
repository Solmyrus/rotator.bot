package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;


import lombok.Data;
import lombok.Getter;

import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk.BalancedDruidWotlkKeybindigs.*;

@Getter
public enum BalancedDruidWotlkCasts {
    STAR_FIRE(STAR_FIRE_KEY, null),
    STAR_FALL(STAR_FALL_KEY, null),
    FAERIE_FIRE(FAERIE_FIRE_KEY, null),
    WRATH(WRATH_KEY, null),
    MOON_FIRE(MOON_FIRE_KEY, null),

    INSECT_SWARM(INSECT_SWARM_KEY, null),
    POTION1(POTION1_KEY, null),
    POTION2(POTION2_KEY, null),
    INNERVATE(INNERVATE_KEY, null);

    private int key;
    private Integer modifier;

    BalancedDruidWotlkCasts(int key, Integer modifier) {
        this.key = key;
        this.modifier = modifier;
    }
}
