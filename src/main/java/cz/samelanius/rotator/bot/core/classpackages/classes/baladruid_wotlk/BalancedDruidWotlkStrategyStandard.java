package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;

import cz.samelanius.rotator.bot.core.engine.actions.KeyPress;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

import java.awt.event.KeyEvent;

import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk.BalancedDruidWotlkCasts.*;

public class BalancedDruidWotlkStrategyStandard implements BalancedDruidWotlkStrategy {

    private static final long CAST_CD = 300;

    private long lastCast = 0L;
    private EclipseMode eclipseMode = EclipseMode.SOLAR;

    @Override
    public ResultActions update(BalancedDruidWotlkPlayerData player) {
        if (player.isActivateManaPotion()) return castSpell(MANA_POTION);
        if (player.isActivateDarkRune()) return castSpell(DARK_RUNE);
        if (player.isActivateTrinket()) return castSpell(TRINKET);
        if (player.isActivateInnervate()) return castSpell(INNERVATE);
        if (player.isActivateDestructionPotion()) return castSpell(DESTRUCTION_POTION);

        if(player.getSpellFaerieFire().isCastable()) return castSpell(FAERIE_FIRE);

        resolveEclipseMode(player);

        System.out.println(eclipseMode);

        switch (eclipseMode) {
            case LUNAR: {
                if(player.getSpellMoonFire().isCastable()) return castSpell(MOON_FIRE);
                if(player.getSpellStarFire().isCastable()) return castSpell(STAR_FIRE);
                break;
            }

            case SOLAR: {
                if(player.getSpellInsectSwarm().isCastable()) return castSpell(INSECT_SWARM);
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
                if(player.getSpellInsectSwarm().isCastable()) return castSpell(INSECT_SWARM);
                if(player.getSpellMoonFire().isCastable()) return castSpell(MOON_FIRE);
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
        if(eclipseMode.equals(EclipseMode.LUNAR) && !player.isLunarEclipseAura()) eclipseMode = EclipseMode.AFTER_LUNAR;
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


}
