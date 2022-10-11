package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;

import cz.samelanius.rotator.bot.core.engine.actions.KeyPress;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

import java.awt.event.KeyEvent;

import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk.BalancedDruidWotlkCasts.*;
import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk.EclipseMode.AFTER_LUNAR;
import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk.EclipseMode.AFTER_SOLAR;

public class BalancedDruidWotlkStrategyStandard implements BalancedDruidWotlkStrategy {

    private static final long CAST_CD = 300;

    private long lastCast = 0L;
    private EclipseMode eclipseMode = AFTER_SOLAR;

    @Override
    public ResultActions update(BalancedDruidWotlkPlayerData player) {
        if (player.isActivatePotion1()) return castSpell(POTION1);
        if (player.isActivatePotion2()) return castSpell(POTION2);
        if (player.isActivateInnervate()) return castSpell(INNERVATE);

        if(player.getSpellFaerieFire().isCastable()) return castSpell(FAERIE_FIRE);

        resolveEclipseMode(player);

        switch (eclipseMode) {
            case LUNAR: {
                if(player.getSpellMoonFire().isCastable()) return castSpell(MOON_FIRE);
                if(player.getSpellStarFire().isCastable()) return castSpell(STAR_FIRE);
                break;
            }

            case SOLAR: {
                if(player.getWrath().isCastable()) return castSpell(WRATH);
                break;
            }

            case AFTER_LUNAR: {
                if(player.getSpellMoonFire().isCastable()) return castSpell(MOON_FIRE);
                if(player.getSpellStarFall().isCastable()) return castSpell(STAR_FALL);
                if(player.getSpellStarFire().isCastable()) return castSpell(STAR_FIRE);
                break;
            }
            case AFTER_SOLAR: {
                if(player.getSpellStarFall().isCastable()) return castSpell(STAR_FALL);
                if(player.getWrath().isCastable()) return castSpell(WRATH);
                break;
            }

        }
        return ResultActions.noAction("Neni co delat");
    }

    private void resolveEclipseMode(BalancedDruidWotlkPlayerData player) {
        if(player.isLunarEclipseAura()) eclipseMode = EclipseMode.LUNAR;
        if(player.isSolarEclipseAura()) eclipseMode = EclipseMode.SOLAR;
        if(eclipseMode.equals(EclipseMode.LUNAR) && !player.isLunarEclipseAura()) eclipseMode = AFTER_LUNAR;
        if(eclipseMode.equals(EclipseMode.SOLAR) && !player.isSolarEclipseAura()) eclipseMode = EclipseMode.SOLAR;
    }

    private ResultActions castSpell(BalancedDruidWotlkCasts cast) {
        /*if(System.currentTimeMillis() - CAST_CD < lastCast) {
            return ResultActions.noAction("CastCD");
        }
        lastCast = System.currentTimeMillis();
        */
        return ResultActions.action(KeyPress.pressKey(cast.getKey()).withModificator(cast.getModifier()));

    }


    public void eclipseMode() {
        eclipseMode = AFTER_SOLAR;
    }
}
